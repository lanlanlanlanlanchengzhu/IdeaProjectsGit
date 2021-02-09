/**
 * @author x
 * @date 2020-08-22
 */
public class Singleton {

    private static volatile Singleton singleton;

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
