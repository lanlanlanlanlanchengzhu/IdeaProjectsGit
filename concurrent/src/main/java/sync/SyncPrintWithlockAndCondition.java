package sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncPrintWithlockAndCondition {

    class SyncMonitor {
        int val = 2;
    }

    private final SyncMonitor syncMonitor = new SyncMonitor();

    String[] noArr = Helper.getNoArr(52);
    String[] charArr = Helper.getCharArr(26);

    private Lock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    public Runnable noThread () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < noArr.length; i = i+2) {
                    try {
                        lock.lock();
                        while (syncMonitor.val == 1) {
                            try {
                                condition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Helper.print(noArr[i], noArr[i+1]);
                        syncMonitor.val = 1;
                        condition.signal();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
    }

    public Runnable charThread () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < charArr.length; i++) {
                    try {
                        lock.lock();
                        while (syncMonitor.val == 2) {
                            try {
                                condition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Helper.print(charArr[i]);
                        syncMonitor.val = 2;
                        condition.signal();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
    }

    public static void main(String[] args) {
        SyncPrintWithlockAndCondition syncPrint = new SyncPrintWithlockAndCondition();
        Helper.instance.run(syncPrint.noThread());
        Helper.instance.run(syncPrint.charThread());
        Helper.shutdown();
    }

}
