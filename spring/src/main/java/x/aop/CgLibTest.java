package x.aop;

public class CgLibTest {

    public static void main(String[] args) {
        CgLibProxy proxyInstance = new CgLibProxy();
        // 获取代理类
        SayServiceImpl sayServiceInstance = (SayServiceImpl) proxyInstance.getProxy(SayServiceImpl.class);
        sayServiceInstance.say("hw");
    }

}
