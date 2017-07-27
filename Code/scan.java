package Code;

/**
 * Created by xwz on 3/28/17.
 */
import java.io.*;
import java.util.*;
class scan {

    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int a, b;
        while(cin.hasNextInt())
        {
            a = cin.nextInt();
            b = cin.nextInt();
            System.out.println(a + b);
        }
    }
}

