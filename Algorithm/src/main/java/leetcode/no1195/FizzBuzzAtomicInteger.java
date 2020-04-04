package leetcode.no1195;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.function.IntConsumer;

/**
 * @author x
 * @date 2020-04-03
 * @see <href="https://leetcode-cn.com/problems/fizz-buzz-multithreaded/"/>
 *
 * 多线程共享资源问题——AtomicInteger解决方案
 * 利用CAS
 * 核心思想不变，获取锁——执行——释放锁
 */
public class FizzBuzzAtomicInteger {

    // 0-锁占用；1-锁空闲
    AtomicInteger atomicInteger = new AtomicInteger(1);

    private int curr = 1;

    private int n;

    public FizzBuzzAtomicInteger(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (curr <= n) {
            // CAS不断重试，获取锁
            while (!atomicInteger.compareAndSet(1, 0)) {
                LockSupport.parkNanos(1L);
            }
            while (curr % 3 == 0 && curr % 5 != 0 && curr <= n) {
                printFizz.run();
                curr++;
            }
            // 释放锁
            atomicInteger.set(1);
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (curr <= n) {
            // CAS不断重试，获取锁
            while (!atomicInteger.compareAndSet(1, 0)) {
                LockSupport.parkNanos(1L);
            }
            while (curr % 3 != 0 && curr % 5 == 0 && curr <= n) {
                printBuzz.run();
                curr++;
            }
            // 释放锁
            atomicInteger.set(1);
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (curr <= n) {
            // CAS不断重试，获取锁
            while (!atomicInteger.compareAndSet(1, 0)) {
                LockSupport.parkNanos(1L);
            }
            while (curr % 3 == 0 && curr % 5 == 0 && curr <= n) {
                printFizzBuzz.run();
                curr++;
            }
            // 释放锁
            atomicInteger.set(1);
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (curr <= n) {
            // CAS不断重试，获取锁
            while (!atomicInteger.compareAndSet(1, 0)) {
                LockSupport.parkNanos(1L);
            }
            while (curr % 3 != 0 && curr % 5 != 0 && curr <= n) {
                printNumber.accept(curr);
                curr++;
            }
            // 释放锁
            atomicInteger.set(1);
        }
    }

}
