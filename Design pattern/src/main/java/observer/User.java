package observer;

/**
 * @author xiasiyu
 * @desc
 * @create 2018/04/07 1:27
 **/
public class User implements Observer{

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        read(message);
    }

    private void read(String message) {
        System.out.println("用户（观察者）接受微信（被观察者）推送消息，内容是：" + message);
    }
}
