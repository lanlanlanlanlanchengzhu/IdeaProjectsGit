package interview.concurrency;

/**
 * @author x
 * @date 2020-06-06
 */
public class SerialInternal extends Thread {

    private int id;

    public SerialInternal(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("current : " + id);
    }



}
