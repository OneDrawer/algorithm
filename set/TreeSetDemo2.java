package set;

import day15.ObjectArray.Student;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by xwz on 8/24/16.
 */
public class TreeSetDemo2 {
    public static void main(String[] args) {
//        TreeSet<Student> ts = new TreeSet<Student>();

        //如果一个方法的参数是接口, 那么真的要的是接口的实现类的对象
        //而匿名内部类就可以实现这个东西
        TreeSet<Student> ts = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //比较长度
                int num = o1.getName().length() - o2.getName().length();
                //比较内容
                int num2 = num == 0 ? o1.getName().compareTo(o2.getName()) : num;
                //比较年龄
                int num3 = num2 == 0 ? o1.getAge() - o2.getAge() : num2;
                return num3;
            }
        });
        Student s1 = new Student("linqing2", 23);
        Student s2 = new Student("zhangguorong", 24);
        Student s3 = new Student("wanglihong", 25);
        Student s4 = new Student("linqing", 23);
        Student s5 = new Student("linqing", 23);
        Student s6 = new Student("liushishi", 22);
        Student s7 = new Student("linqing", 27);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);
        ts.add(s7);

        for (Student s : ts) {
            System.out.println(s);
        }
    }
}
