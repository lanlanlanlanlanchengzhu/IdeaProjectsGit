package sync;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class SyncPrintWithBlockingQueue {

    class SyncMonitor {
        int val = 2;
    }

    BlockingQueue queue = new LinkedBlockingDeque();

    BlockingQueue noQueue = new LinkedBlockingDeque();
    BlockingQueue charQueue = new LinkedBlockingDeque();

    String[] noArr = Helper.getNoArr(52);
    String[] charArr = Helper.getCharArr(26);

    public Runnable noThread () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < noArr.length; i = i+2) {
                    Helper.print(noArr[i], noArr[i+1]);
                    queue.offer("charThread");
                    while (!"noThread".equals(queue.peek())) { }
                    queue.poll();
                }
            }
        };
    }

    public Runnable charThread () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < charArr.length; i++) {
                    while (!"charThread".equals(queue.peek())) { }
                    Helper.print(charArr[i]);
                    queue.poll();
                    queue.offer("noThread");
                }
            }
        };
    }

    public Runnable noThreadV2 () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < noArr.length; i = i+2) {
                    Helper.print(noArr[i], noArr[i+1]);
                    try {
                        charQueue.put("start");
                        noQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    public Runnable charThreadV2 () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < charArr.length; i++) {
                    try {
                        charQueue.take();
                        Helper.print(charArr[i]);
                        noQueue.put("start");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        SyncPrintWithBlockingQueue syncPrint = new SyncPrintWithBlockingQueue();
        Helper.instance.run(syncPrint.noThread());
        Helper.instance.run(syncPrint.charThread());
        Thread.sleep(2000);
        System.out.println();
        Helper.instance.run(syncPrint.noThreadV2());
        Helper.instance.run(syncPrint.charThreadV2());
        Helper.shutdown();
    }

}
