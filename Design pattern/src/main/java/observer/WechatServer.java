package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiasiyu
 * @desc
 * @create 2018/04/07 1:13
 **/
public class WechatServer implements Observerable{

    private List<Observer> observerList;
    private String notifyContent;

    public WechatServer() {
        this.observerList = new ArrayList<Observer>();
    }

    @Override
    public void registryObserver(Observer observer) {
        System.out.println("【微信（被观察者）】增加订阅用户" + observer);
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(!observerList.isEmpty()){
            System.out.println("【微信（被观察者）】用户退订" + observer);
            observerList.remove(observer);
        }
    }

    @Override
    public void noticeObserver() {
        Observer observer;
        for (int i = 0; i < observerList.size(); i++) {
            observer = observerList.get(i);
            observer.update(notifyContent);
        }
    }

    public void setNotifyContent(String notifyContent){
        this.notifyContent = notifyContent;
        System.out.println("微信（被观察者）发送推送消息：" + notifyContent);
        noticeObserver();
    }

}
