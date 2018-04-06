package x;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
* class_name: StudentBean
* package: x
* describe: 
* author: xiasiyu
* creat_date: 2018/4/5
* creat_time: 19:27
**/
public class StudentBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware {
    private String name;
    private int age;

    private String beanNeme;//实现了BeanNameAware接口，Spring可以将beanName注入该属性中
    private BeanFactory beanFactory;//实现BeanFactory接口，spring可以将BeanFactory注入该属性中

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【set注入】注入student的name属性" + name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("【set注入】注入student的age属性");
        this.age = age;
    }

    /**
    * class_name: 自定义的初始化方法
    * param:
    * describe:
    * author: xiasiyu
    * creat_date: 2018/4/5
    * creat_time: 16:14
    **/
    /*public void myInit(){
        System.out.println("【init-method】调用init-method属性配置的初始化方法");
    }*/
    public void myInit(){
        System.out.println("【init-method】调用init-method属性配置的初始化方法");
    }
    /**
    * class_name: 自定义的销毁方法
    * param:
    * describe:
    * author: xiasiyu
    * creat_date: 2018/4/5
    * creat_time: 16:13
    **/
    public void myDestroy(){
        System.out.println("【destory-method】调用destory-method属性配置的销毁方法");
    }

    public StudentBean() {
        System.out.println("【StudentBean构造方法】StudentBean无参构造方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware的setBeanFactory得到的beanFactory引用：" + beanFactory);
    }

    @Override
    public void setBeanName(String benaNeme) {
        this.beanNeme = beanNeme;
        System.out.println("【BeanNameAware接口】调用BeanNameAware的setBeanName得到bean的名称：" + benaNeme);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean接口的afterPropertiesSet方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【DisposableBean接口】调用DisposableBean接口的destory方法");
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", beanNeme='" + beanNeme + '\'' +
                ", beanFactory=" + beanFactory +
                '}';
    }
}
