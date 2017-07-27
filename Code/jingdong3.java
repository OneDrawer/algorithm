package Code;

import java.util.Scanner;

/**
 * Created by xwz on 4/7/17.
 */
public class jingdong3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] p = new int[n];
        for(int i = 0; i < n; i++) {
            p[i] = cin.nextInt();
        }
        int rig = 0;
        double x = n * 0.6;
        if(x > (int) x)
            rig = (int) x + 1;
        else
            rig = (int) x;

    }
}
