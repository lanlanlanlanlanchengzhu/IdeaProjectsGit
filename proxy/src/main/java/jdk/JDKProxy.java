package jdk;

import business.IUserService;
import business.impl.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxy {

    public static void main(String[] args) {
        IUserService iUserService = new UserService();
        InvocationHandler invocationHandler = new MyInvocationHandler(iUserService);
        IUserService userServiceProxy = (IUserService) Proxy.newProxyInstance(iUserService.getClass().getClassLoader(), iUserService.getClass().getInterfaces(), invocationHandler);
        System.out.println(userServiceProxy.getAge(1));
        System.out.println(userServiceProxy.getName(1));
    }

}
