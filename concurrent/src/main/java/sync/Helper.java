package sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 编写两个线程，一个线程打印1~25，另一个线程打印字母A~Z，打印顺序为12A34B56C……5152Z，要求使用线程间的通信
 */

public enum Helper {

    // 实例
    instance;

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static String[] getNoArr (int maxSize) {
        String[] noArr = new String[maxSize];
        for (int i = 0; i < maxSize; i++) {
            noArr[i] = String.valueOf(i + 1);
        }
        return noArr;
    }

    public static final String[] getCharArr (int maxSize) {
        int asciiBasic = 65; //ascii对应A
        String[] charArr = new String[maxSize];
        for (int i = 0; i < maxSize; i++) {
            charArr[i] = String.valueOf((char)(asciiBasic + i));
        }
        return charArr;
    }

    public static void print (String... values) {
        for (String str : values) {
            System.out.print(str);
        }
    }

    public static void run (Runnable task) {
        threadPool.submit(task);
    }

    /**
     * shutdown gracefully
     */
    public static void shutdown () {
        threadPool.shutdown();
    }

}
