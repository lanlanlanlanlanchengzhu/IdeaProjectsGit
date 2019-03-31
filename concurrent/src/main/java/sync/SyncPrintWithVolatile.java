package sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncPrintWithVolatile {

    class SyncMonitor {
        int val = 2;
    }

    // volatile修饰的变量直接存在main memory中，不同线程对该变量的修改直接写入main memory中，而不是像其它变量一样
    // 在local thread里面产生一份copy
    // volatile能保证所修饰的变量对于多个线程可见行，即只要被修改，其它线程能立即感知修改后的值
    private volatile SyncMonitor syncMonitor = new SyncMonitor();

    String[] noArr = Helper.getNoArr(52);
    String[] charArr = Helper.getCharArr(26);

    public Runnable noThread () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < noArr.length; i = i+2) {
                    while (syncMonitor.val == 1) { }
                    Helper.print(noArr[i], noArr[i+1]);
                    syncMonitor.val = 1;
                }
            }
        };
    }

    public Runnable charThread () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < charArr.length; i++) {
                    while (syncMonitor.val == 2) { }
                    Helper.print(charArr[i]);
                    syncMonitor.val = 2;
                }
            }
        };
    }

    public static void main(String[] args) {
        SyncPrintWithVolatile syncPrint = new SyncPrintWithVolatile();
        Helper.instance.run(syncPrint.noThread());
        Helper.instance.run(syncPrint.charThread());
        Helper.shutdown();
    }

}
