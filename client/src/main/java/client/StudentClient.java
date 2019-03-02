package client;

import inter.StudentInter;

import java.rmi.Naming;

public class StudentClient {
    /**
     * 查找远程对象并调用远程方法
     */
    public static void main(String[] argv)
    {
        try
        {
            StudentInter stu = (StudentInter) Naming.lookup("stu");

            //如果要从另一台启动了RMI注册服务的机器上查找hello实例
            //StudentInter stu = (StudentInter) Naming.lookup("//localhost:1099/stu");

            //调用远程方法 JDBC连接数据库方式
            String callBack=stu.getStudentName("i");
            System.out.println(callBack);
        }
        catch (Exception e)
        {
            System.out.println("服务器异常: " + e);
        }
    }
}
