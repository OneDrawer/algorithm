package day15.ObjectArray;

/**
 * Created by xwz on 8/19/16.
 */
public class ObjectArray {
    public static void main(String[] args) {
        Student[] students = new Student[5];

        Student s1 = new Student("lin", 23);
        Student s2 = new Student("wang", 34);
        Student s3 = new Student("liu", 22);
        Student s4 = new Student("guo", 24);
        Student s5 = new Student("zhang", 25);

        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
        students[3] = s4;
        students[4] = s5;

        for(int x = 0; x < students.length; x++) {
            System.out.println(students[x]);
        }
    }
}
