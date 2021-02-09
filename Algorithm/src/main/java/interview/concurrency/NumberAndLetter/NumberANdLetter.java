package interview.concurrency.NumberAndLetter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author x
 * @date 2020-09-06
 */
public class NumberANdLetter {

    private static final int endCount = 26;

    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition numberCondition = lock.newCondition();
    private static final Condition letterCondition = lock.newCondition();

    private static boolean printNumber = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // number
                int i = 0;
                while (i < endCount) {
                    lock.lock();
                    try {
                        while (printNumber == false) {
                            numberCondition.await();
                        }
                        System.out.println("Number : " + (i * 2 + 1));
                        System.out.println("Number : " + (i * 2 + 2));
                        i++;
                        printNumber = false;
                        letterCondition.signal();
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
                // letter
                int i = 0;
                while (i < endCount) {
                    lock.lock();
                    try {
                        while (printNumber == true) {
                            letterCondition.await();
                        }
                        System.out.println("Letter : " + ((char)('A' + i)));
                        i++;
                        printNumber = true;
                        numberCondition.signal();
                    } catch (Exception e) {

                    } finally {
                        lock.unlock();
                    }
                }
            }
        }).start();

    }

}
