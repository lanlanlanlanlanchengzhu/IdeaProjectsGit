package interview.concurrency.NumberAndLetter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author x
 * @date 2020-09-06
 */
public class NumberANdLetterAtomicInteger {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            // Number
            @Override
            public void run() {
                int i = 1;
                while (true) {
                    if (i > 52) {
                        return;
                    }
                    if (atomicInteger.get() < 2) {
                        System.out.println("Number : " + i);
                        i++;
                        atomicInteger.incrementAndGet();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            // Letter
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    if (i >= 26) {
                        return;
                    }
                    if (atomicInteger.get() == 2) {
                        System.out.println("Letter : " + ((char) ('A' + i)));
                        i++;
                        atomicInteger.set(0);
                    }
                }
            }
        }).start();
    }
}
