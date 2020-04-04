package leetcode.no1117;

import java.util.concurrent.Semaphore;

/**
 * @author x
 * @date 2020-04-04
 * @see <href="https://leetcode-cn.com/problems/building-h2o/"/>
 *
 * 线程间通信——通过信号量做同步
 */
public class H2O {

    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(2);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        h.release(2);
    }
}
