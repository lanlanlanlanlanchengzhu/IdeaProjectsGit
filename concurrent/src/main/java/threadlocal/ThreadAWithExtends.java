package threadlocal;

public class ThreadA implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Tools.threadLocal.set("ThreadA:" + i);
            System.out.println("ThreadA get value : " + Tools.threadLocal.get());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
