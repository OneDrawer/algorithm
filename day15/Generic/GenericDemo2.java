package day15.Generic;

import day15.ObjectArray.Student;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by xwz on 8/22/16.
 * 泛型 存储自定义对象并遍历
 */
public class GenericDemo2 {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<Student>();

        Student s1 = new Student("ccaocao", 45);
        Student s2 = new Student("jianggan", 54);
        Student s3 = new Student("zhugeliang",40);

        array.add(s1);
        array.add(s2);
        array.add(s3);

        Iterator<Student> it = array.iterator();
        while(it.hasNext()) {
            Student s = it.next();
            System.out.println(s.getName() + "---" + s.getAge());
        }

        for(int x = 0; x < array.size(); x++) {
            Student s = array.get(x);
            System.out.println(s.getName() + "---" + s.getAge());
        }
    }
}
