package sync;

public class SyncPrint {

    class SyncMonitor {
        int val = 2;
    }

    private final SyncMonitor syncMonitor = new SyncMonitor();

    String[] noArr = Helper.getNoArr(52);
    String[] charArr = Helper.getCharArr(26);

    public Runnable noThread () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < noArr.length; i = i+2) {
                    synchronized (syncMonitor) {
                        while (syncMonitor.val == 1) {
                            try {
                                syncMonitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Helper.print(noArr[i], noArr[i+1]);
                        syncMonitor.val = 1;
                        syncMonitor.notify();
                    }
                }
            }
        };
    }

    public Runnable charThread () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < charArr.length; i++) {
                    synchronized (syncMonitor) {
                        while (syncMonitor.val == 2) {
                            try {
                                syncMonitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Helper.print(charArr[i]);
                        syncMonitor.val = 2;
                        syncMonitor.notify();
                    }
                }
            }
        };
    }

    public static void main(String[] args) {
        SyncPrint syncPrint = new SyncPrint();
        Helper.run(syncPrint.noThread());
        Helper.run(syncPrint.charThread());
        Helper.shutdown();
    }

}
