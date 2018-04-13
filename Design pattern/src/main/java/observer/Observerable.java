package observer;

/**
* class_name: Observerable
* package: observer
* describe: 设计模式-观察者模式
* author: xiasiyu
* creat_date: 2018/4/7
* creat_time: 1:02
**/
public interface Observerable {
    public void registryObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void noticeObserver();
}
