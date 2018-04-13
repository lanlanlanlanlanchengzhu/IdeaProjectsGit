package x;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author xiasiyu
 * @desc
 * @create 2018/04/05 18:47
 **/
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
    * class_name:
    * param: 
    * describe: 重写BeanFactoryPostProcessor接口的postProcessBeanFactory方法，可以通过该方法为beanFactory进行设置
    * @author: xiasiyu
    * creat_date: 2018/4/5
    * creat_time: 19:03
    **/
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("【BeanFactoryPostProcess接口】调用BeanFactoryPostProcess接口的postProcessBeanFactory方法");
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("studentBean");
        beanDefinition.getPropertyValues().addPropertyValue("age", "21");
    }
}
