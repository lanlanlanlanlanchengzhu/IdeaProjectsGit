package interview.concurrency;

/**
 * @author x
 * @date 2020-06-06
 */
public class Serial {

    public static void main(String[] args) throws InterruptedException {
        SerialInternal serialInternal1 = new SerialInternal(1);
        SerialInternal serialInternal2 = new SerialInternal(2);
        SerialInternal serialInternal3 = new SerialInternal(3);

        serialInternal1.start();
        serialInternal1.join();
        serialInternal2.start();
        serialInternal2.join();
        serialInternal3.start();
    }

}
