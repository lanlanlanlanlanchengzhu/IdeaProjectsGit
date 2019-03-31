package sync;

import java.util.concurrent.atomic.AtomicInteger;

public class SyncPrintWithAtomicInteger {

    class SyncMonitor {
        int val = 2;
    }

    private AtomicInteger syncMonitor = new AtomicInteger(2);

    String[] noArr = Helper.getNoArr(52);
    String[] charArr = Helper.getCharArr(26);

    public Runnable noThread () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < noArr.length; i = i+2) {
                    while (syncMonitor.get() == 1) { }
                    Helper.print(noArr[i], noArr[i+1]);
                    syncMonitor.set(1);
                }
            }
        };
    }

    public Runnable charThread () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < charArr.length; i++) {
                    while (syncMonitor.get() == 2) { }
                    Helper.print(charArr[i]);
                    syncMonitor.set(2);
                }
            }
        };
    }

    public static void main(String[] args) {
        SyncPrintWithAtomicInteger syncPrint = new SyncPrintWithAtomicInteger();
        Helper.instance.run(syncPrint.noThread());
        Helper.instance.run(syncPrint.charThread());
        Helper.shutdown();
    }

}
