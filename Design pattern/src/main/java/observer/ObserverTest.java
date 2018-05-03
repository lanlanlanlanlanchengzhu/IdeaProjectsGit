package observer;

/**
 * @author xiasiyu
 * @desc
 * @create 2018/04/07 10:30
 **/
public class ObserverTest {

    public static void main(String[] args) {
        WechatServer wechatServer = new WechatServer();

        User zhangSan = new User("zhangSan");
        User liSi = new User("liSi");
        User wangWu = new User("wangWu");

        wechatServer.registryObserver(zhangSan);
        wechatServer.registryObserver(liSi);
        wechatServer.registryObserver(wangWu);

        wechatServer.setNotifyContent("xia siyu zui shuai");
        System.out.println("----------------------------------------------------------------");

        wechatServer.removeObserver(zhangSan);
        wechatServer.setNotifyContent("li qingtai zui chou");

    }

}
