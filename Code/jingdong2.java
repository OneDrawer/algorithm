package Code;

import java.util.Scanner;

/**
 * Created by xwz on 4/7/17.
 */
public class jingdong2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
//        char[] ch1 = new char[n];
//        char[] ch2 = new char[n];
        String ch1;
        String ch2;
        ch1 = cin.next();
        ch2 = cin.next();
        char[] result = new char[n];
        for(int i = 0; i < n; i++) {
            if(ch1.charAt(i) == ch2.charAt(i))
                result[i] = '0';
            else
                result[i] = '1';
        }
        //System.out.println(ch1 + "   " + ch2);
        int res = 0;
        for(int i = 0; i < n; i++) {
            res = res*2 + result[i] - '0';
        }
        System.out.println(res);
    }
}
