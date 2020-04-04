package leetcode.no1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author x
 * @date 2020-04-03
 * @see <href="https://leetcode-cn.com/problems/fizz-buzz-multithreaded/"/>
 *
 * 多线程共享资源问题——semaphore解决
 */
public class FizzBuzz {

    Semaphore semaphore = new Semaphore(1);

    private int curr = 1;

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (curr <= n) {
            semaphore.acquire();
            while (curr % 3 == 0 && curr % 5 != 0 && curr <= n) {
                printFizz.run();
                curr++;
            }
            semaphore.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (curr <= n) {
            semaphore.acquire();
            while (curr % 3 != 0 && curr % 5 == 0 && curr <= n) {
                printBuzz.run();
                curr++;
            }
            semaphore.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (curr <= n) {
            semaphore.acquire();
            while (curr % 3 == 0 && curr % 5 == 0 && curr <= n) {
                printFizzBuzz.run();
                curr++;
            }
            semaphore.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (curr <= n) {
            semaphore.acquire();
            while (curr % 3 != 0 && curr % 5 != 0 && curr <= n) {
                printNumber.accept(curr);
                curr++;
            }
            semaphore.release();
        }
    }

}
