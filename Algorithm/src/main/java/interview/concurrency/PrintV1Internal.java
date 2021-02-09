package interview.concurrency;

/**
 * @author x
 * @date 2020-06-06
 */
public class PrintV1Internal extends Thread {

    public static volatile int count = 1;
    private int id;

    public PrintV1Internal(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        synchronized (PrintV1Internal.class) {
            while (count < 75) {
                while (count / 5 % 3 + 1 != id) {
                    try {
                        PrintV1Internal.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count < 75) {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("thread : " + id + "print : " + count++);
                    }
                }
                PrintV1Internal.class.notifyAll();
            }
        }
    }
}
