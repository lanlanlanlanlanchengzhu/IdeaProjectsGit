package server;

import impl.StudentImpl;
import inter.StudentInter;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class StudentServer {


    /**
     * 启动 RMI 注册服务并进行对象注册
     */

    public static void main(String[] args) {
        try {
            // 启动RMI注册服务，指定端口为1099 （1099为默认端口）
            // 也可以通过命令 ＄java_home/bin/rmiregistry 1099启动
            // 这里用这种方式避免了再打开一个DOS窗口
            // 而且用命令rmiregistry启动注册服务还必须事先用RMIC生成一个stub类为它所用
            LocateRegistry.createRegistry(1099);

            // 创建远程对象的一个或多个实例，下面是stu对象
            // 可以用不同名字注册不同的实例

            // 把hello注册到RMI注册服务器上，命名为stu;注意：此处如果用的是Spring框架的话我们需要先加载Spring的配置文件
            StudentInter stu = new StudentImpl();
            Naming.rebind("stu", stu);

            // 如果要把stu实例注册到另一台启动了RMI注册服务的机器上
            // Naming.rebind("//机器IP地址:1099/stu",stu);
            System.out.println("服务器已启动！");
        } catch (Exception e) {
            System.out.println("服务器启动失败: " + e);
        }
    }

}
