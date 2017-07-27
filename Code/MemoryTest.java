package Code;

/**
 * Created by xwz on 9/14/16.
 */
public class MemoryTest {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo";
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");
        String s6 = s5.intern();
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;
        String s10 = s1;

        System.out.println(s1 == s2);  // true
        System.out.println(s1 == s3);  // true
        System.out.println(s1 == s4);  // false
        System.out.println(s1 == s9);  // false
        System.out.println(s4 == s5);  // false
        System.out.println(s1 == s6);  // true
        System.out.println(s1 == s5);  // false
        System.out.println(s1 == s10);
        System.out.println("----------------");

        System.out.println("s1:" + s1.hashCode());
        System.out.println("s2:" + s2.hashCode());
        System.out.println("s3:" + s3.hashCode());
        System.out.println("s4:" + s4.hashCode());
        System.out.println("s5:" + s5.hashCode());
        System.out.println("s6:" + s6.hashCode());
        System.out.println("s7:" + s7.hashCode());
        System.out.println("s8:" + s8.hashCode());
        System.out.println("s9:" + s9.hashCode());
        System.out.println("s10:" + s10.hashCode());
    }
}
