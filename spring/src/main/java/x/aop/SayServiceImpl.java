package x.aop;

public class SayServiceImpl implements SayService {

    @Override
    public void say(String sth) {
        System.out.println(sth);
    }

}
