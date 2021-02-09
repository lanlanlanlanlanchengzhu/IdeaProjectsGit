package interview.concurrency;

/**
 * @author x
 * @date 2020-06-06
 */
public class PrintInternal {

    private static int count = 1;
    private static boolean numFlag = true;

    public synchronized void printNum () {
        while (!numFlag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(count * 2 - 1);
        System.out.println(count * 2);
        numFlag = false;
        this.notifyAll();
    }

    public synchronized void printLetter () {
        while (numFlag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println((char) (count++ - 1 + 'A'));
        numFlag = true;
        this.notifyAll();
    }

}
