package sync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SyncPrintWithCyclicBarrier {

    class SyncMonitor {
        int val = 2;
    }

    private List<String> list;
    private CyclicBarrier cyclicBarrier;

    /**
     * keypoint
     */
    private Runnable barrierAction () {
        return new Runnable() {
            @Override
            public void run() {
                Collections.sort(list);
                for (String oneStr : list) {
                    Helper.print(oneStr);
                }
                list.clear();
            }
        };
    }

    public SyncPrintWithCyclicBarrier () {
        list = Collections.synchronizedList(new ArrayList<>());
        cyclicBarrier = new CyclicBarrier(2, barrierAction());
    }

    String[] noArr = Helper.getNoArr(52);
    String[] charArr = Helper.getCharArr(26);

    public Runnable noThread () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < noArr.length; i = i+2) {
                    list.add(noArr[i]);
                    list.add(noArr[i+1]);
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    public Runnable charThread () {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < charArr.length; i++) {
                    list.add(charArr[i]);
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    public static void main(String[] args) {
        SyncPrintWithCyclicBarrier syncPrint = new SyncPrintWithCyclicBarrier();
        Helper.instance.run(syncPrint.noThread());
        Helper.instance.run(syncPrint.charThread());
        Helper.shutdown();
    }

}
