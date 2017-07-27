package TreeMap;

import day15.ObjectArray.Student;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by xwz on 8/25/16.
 */

public class TreeMapDemo2 {
    public static void main(String[] args) {
        TreeMap<Student, String> tm = new TreeMap(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int num = o1.getAge() - o2.getAge();
                int num2 = num == 0 ? o2.getName().compareTo(o1.getName()) : num;
                return num2;
            }
        });

        Student s1 = new Student("panan", 30);
        Student s2 = new Student("liuxiahui", 32);
        Student s3 = new Student("tangbohu", 33);
        Student s4 = new Student("yanqing", 32);
        Student s5 = new Student("tangbohu", 33);

        tm.put(s1, "songchao");
        tm.put(s2, "yuanchao");
        tm.put(s3, "mingchao");
        tm.put(s4, "qingchao");
        tm.put(s5, "hanchao");

        Set<Student> set = tm.keySet();
        for(Student key : set) {
            String value = tm.get(key);
            System.out.println(key.getName() + "---" + key.getAge() + "---" + value);
        }
    }
}
