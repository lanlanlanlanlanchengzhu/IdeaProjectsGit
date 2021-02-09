package interview.concurrency.ThreeThreadConcurrencyPrint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author x
 * @date 2020-09-06
 */
public class ThreeThreadConcurrencyPrint implements Runnable {

    /**
     * 三个线程，每个线程打印5个数字，打印至100结束
     */

    public static final ReentrantLock lock = new ReentrantLock();

    public static final Condition[] conditions = new Condition[]{lock.newCondition(), lock.newCondition(), lock.newCondition()};

    public static int currCount = 1;

    public static final int endCount = 100;

    private int id;

    public ThreeThreadConcurrencyPrint(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (currCount <= endCount) {
            lock.lock();
            try {
                while (currCount / 5 % conditions.length != id) {
                    conditions[(id  + 1) % conditions.length].signal();
                    conditions[id % conditions.length].await();
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println(id + " : " + currCount++);
                }
                conditions[(id  + 1) % conditions.length].signal();
                conditions[id % conditions.length].await();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
        end();
    }

    private void end() {
        lock.lock();
        try {
            conditions[(id + 1) % conditions.length].signal();
            conditions[(id + 2) % conditions.length].signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new ThreeThreadConcurrencyPrint(i)).start();
        }
    }

}
