package observer;

/**
* class_name: Observer
* package: observer
* describe: 抽象观察者
 * 当被观察者调用notifyObserver()方法时，观察者的update()方法会被回调
* author: xiasiyu
* creat_date: 2018/4/7
* creat_time: 1:09
**/
public interface Observer {
    public void update(String message);
}
