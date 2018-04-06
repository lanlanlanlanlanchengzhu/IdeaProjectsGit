package x;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author xiasiyu
 * @desc
 * @create 2018/04/05 16:31
 **/
public class MyBeanPostProcessor implements BeanPostProcessor{
    public MyBeanPostProcessor() {
        System.out.println("【BeanPostProcessor接口】调用BeanPostProcessor接口的构造方法");
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("【BeanPostProcessor接口】调用BeanPostProcessor接口的postProcessorBeforeInitialization方法，这里可对" + s + "的属性进行修改");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("【BeanPostProcessor接口】调用BeanPostProcessor接口的postProcessorAfterInitialization方法");
        return o;
    }
}
