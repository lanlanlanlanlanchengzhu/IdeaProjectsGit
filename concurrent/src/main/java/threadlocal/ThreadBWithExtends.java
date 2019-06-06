package threadlocal;

public class ThreadB implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Tools.threadLocal.set("ThreadB:" + i);
            System.out.println("ThreadB get value : " + Tools.threadLocal.get());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
