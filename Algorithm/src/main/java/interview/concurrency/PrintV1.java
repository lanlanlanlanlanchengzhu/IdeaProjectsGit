package interview.concurrency;

/**
 * 线程1：1～5，线程2：6~10...
 *
 * @author x
 * @date 2020-06-06
 */
public class PrintV1 {

    public static void main(String[] args) {
        new PrintV1Internal(1).start();
        new PrintV1Internal(2).start();
        new PrintV1Internal(3).start();
    }

}
