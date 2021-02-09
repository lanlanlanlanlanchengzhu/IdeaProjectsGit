package interview.concurrency.TowThreadConcurrentPrint;

/**
 * @author x
 * @date 2020-09-06
 */
public class OddEvenPrint implements Runnable{

    public static int currCount = 0;
    public static final int endCount = 100;

    public static final Object lock = new Object();

    @Override
    public void run() {
        while (currCount <= endCount) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " : " + currCount++);
                lock.notifyAll();
                try {
                    if (currCount <= endCount) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new OddEvenPrint(), "odd ");
        Thread thread2 = new Thread(new OddEvenPrint(), "even");
        thread1.start();
        thread2.start();
    }

}
