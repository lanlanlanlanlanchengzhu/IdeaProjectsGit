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

        Children children = new Children();
        children.setId("1");
        children.setSex("male");
        System.out.println(children.getId());
        System.out.println(children.getSex());
        objectOutputStream.writeObject(children);
        objectOutputStream.flush();
        objectOutputStream.close();

        Children inChildren = (Children) objectInputStream.readObject();
        System.out.println("" + inChildren.getId());
        System.out.println("" + inChildren.getSex());

        /*SerializeTest serializeTest = new SerializeTest();
        objectOutputStream.writeObject(serializeTest);
        objectOutputStream.close();

        //序列化后修改为10
        SerializeTest.staticVar = 10;

        SerializeTest inSerializeTest = (SerializeTest)objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(inSerializeTest.staticVar);*/

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