package serialize;

import entity.Person;
import entity.Student;

import java.io.*;

/**
 * @author xiasiyu
 * @desc
 * @create 2018/03/28 22:48
 **/
public class SerializeTest implements Serializable{

    public static int staticVar = 5;

    /**
    * class_name: SerializeTest
    * package: serialize
    * describe: 
    * @author: xiasiyu
    * creat_date: 2018/3/28
    * creat_time: 23:30
    **/
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("temp.out");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        FileInputStream fileInputStream = new FileInputStream("temp.out");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        /*Person person = new Person();
        person.setId("1");
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("temp.out");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Person inPerson = (Person) objectInputStream.readObject();
        System.out.println("inPerson.getId():" + inPerson.getId());*/

        /*Student student = new Student();
        student.setName("xiasiyu");
        student.setClassNo("1");
        objectOutputStream.writeObject(student);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("temp.out");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student inStudent = (Student) objectInputStream.readObject();
        System.out.println("" + inStudent.getName());
        System.out.println("" + inStudent.getClassNo());*/

        /*Children children = new Children();
        children.setId("1");
        children.setSex("male");
        System.out.println(children.getId());
        System.out.println(children.getSex());
        objectOutputStream.writeObject(children);
        objectOutputStream.flush();
        objectOutputStream.close();

        Children inChildren = (Children) objectInputStream.readObject();
        System.out.println("反序列化结果：" + inChildren.getId());
        System.out.println("反序列化结果：" + inChildren.getSex());*/

        /*SerializeTest serializeTest = new SerializeTest();
        objectOutputStream.writeObject(serializeTest);
        objectOutputStream.close();

        //序列化后修改为10
        SerializeTest.staticVar = 10;

        SerializeTest inSerializeTest = (SerializeTest)objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(inSerializeTest.staticVar);*/

        Person test = new Person();
        //试图将对象两次写入文件
        objectOutputStream.writeObject(test);
        objectOutputStream.flush();
        System.out.println(new File("temp.out").length());
        objectOutputStream.writeObject(test);
        objectOutputStream.close();
        System.out.println(new File("temp.out").length());

        //从文件依次读出两个文件
        Person p1 = (Person) objectInputStream.readObject();
        Person p2 = (Person) objectInputStream.readObject();
        objectInputStream.close();

        //判断两个引用是否指向同一个对象
        System.out.println(p1 == p2);

    }

}

class Parent{
    String id;
    String name;

    public Parent(){
//        System.out.println("Parent Constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class Children extends Parent implements Serializable{
    String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}