package day15.List;

import day15.ObjectArray.Student;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by xwz on 8/22/16.
 *
 * contains()方法的底层依赖的是 equals()方法
 * 二我们学生类中没有equals()方法, 这个时候,默认使用的是他的父亲Object的 equals()方法
 * Object() 的equals()默认比较的是地址值,所以 他们都添加进来了, new的对象地址值都不一样
 * 按照需求比较成员变量的值,重写equals()方法即可
 */
public class ArrayListDemo3 {
    public static void main(String[] args) {
        ArrayList array = new ArrayList();

        Student s1 = new Student("linqingxia", 23);
        Student s2 = new Student("linzhilin", 32);
        Student s3 = new Student("furong", 32);
        Student s4 = new Student("cuihua", 43);
        Student s5 = new Student("linqingxia", 23);
        Student s6 = new Student("linzhilin", 32);

        array.add(s1);
        array.add(s2);
        array.add(s3);
        array.add(s4);
        array.add(s5);
        array.add(s6);

        ArrayList newArray = new ArrayList();

        Iterator it = array.iterator();
        while(it.hasNext()) {
            Student s = (Student) it.next();
            if(!newArray.contains(s)) {
                newArray.add(s);
            }
        }

        for(int x = 0; x < newArray.size(); x++) {
            Student s = (Student) newArray.get(x);
            System.out.println(s.getName() + "---" + s.getAge());
        }
    }
}
