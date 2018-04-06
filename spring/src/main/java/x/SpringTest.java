package x;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xiasiyu
 * @desc
 * @create 2018/04/05 19:18
 **/
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("------------【容器初始化成功】-------------");
        StudentBean studentBean = (StudentBean) context.getBean("studentBean");
        System.out.println(studentBean);
        System.out.println("-------------【销毁容器】-------------------------------");
        ((ClassPathXmlApplicationContext)context).registerShutdownHook();
    }
}
