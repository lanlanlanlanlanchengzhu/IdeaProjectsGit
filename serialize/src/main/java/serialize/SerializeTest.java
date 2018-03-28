package serialize;

import entity.Person;

import java.io.*;

/**
 * @author xiasiyu
 * @desc
 * @create 2018/03/28 22:48
 **/
public class SerializeTest{

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
        Person person = new Person();
        person.setId("1");
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("temp.out");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Person inPerson = (Person) objectInputStream.readObject();
        System.out.println("inPerson.getId():" + inPerson.getId());
    }

}
