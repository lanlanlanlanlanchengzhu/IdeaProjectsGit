package interview.concurrency;

/**
 * 两个线程交替打印12A34B56C...Z
 *
 * @author x
 * @date 2020-06-06
 */
public class Print {

    public static PrintInternal printInternal = new PrintInternal();

    public static void main(String[] args) {

        new Thread() {
            @Override
            public void run () {
                for (int i = 0; i < 26; i++) {
                    printInternal.printNum();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run () {
                for (int i = 0; i < 26; i++) {
                    printInternal.printLetter();
                }
            }
        }.start();

    }

}
