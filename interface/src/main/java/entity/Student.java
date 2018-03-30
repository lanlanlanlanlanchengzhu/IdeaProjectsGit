package entity;

import java.io.Serializable;

/**
 * @author xiasiyu
 * @desc
 * @create 2018/03/29 0:23
 **/
public class Student implements Serializable{

    String name;
    transient String classNo;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classNo='" + classNo + '\'' +
                '}';
    }

    public String getClassNo() {
        return classNo;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }
}
