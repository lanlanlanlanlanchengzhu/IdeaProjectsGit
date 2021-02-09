package interview.concurrency.HHO;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author x
 * @date 2020-09-06
 */
public class HHO {

    public static ReentrantLock lock = new ReentrantLock();

    public static Condition HCondition = lock.newCondition();
    public static Condition OCondition = lock.newCondition();

    public static final int endCount = 10;

    public static boolean HFlag = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // H Thread
                int i = 0;
                while (i < endCount) {
                    lock.lock();
                    try {
                        while (HFlag == false) {
                            HCondition.await();
                        }
                        System.out.print("HH");
                        i++;
                        HFlag = false;
                        OCondition.signal();
                    } catch (Exception e) {

                    } finally {
                        lock.unlock();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // O Thread
                int i = 0;
                while (i < endCount) {
                    lock.lock();
                    try {
                        while (HFlag == true) {
                            OCondition.await();
                        }
                        System.out.print("O");
                        i++;
                        HFlag = true;
                        HCondition.signal();
                    } catch (Exception e) {

                    } finally {
                        lock.unlock();
                    }
                }
            }
        }).start();

    }

}
