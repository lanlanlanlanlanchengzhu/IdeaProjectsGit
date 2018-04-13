package jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler
{

    private Object targrt;//被代理的对象

    public MyInvocationHandler(Object targrt) {
        super();
        this.targrt = targrt;
    }

    /**
     * @param proxy 被代理者
     * @param method 被执行的方法
     * @param args 参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("getName".equals(method.getName())){
            System.out.println("-------------before:" + method + "-------------");
            Object result = method.invoke(targrt, args);
            System.out.println("-------------after:" + method + "-------------");
            return result;
        }else{
            Object result = method.invoke(targrt, args);
            return result;
        }
    }
}
