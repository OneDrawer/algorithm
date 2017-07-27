package DP;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by xwz on 4/11/17.
 */
public class PassTest1 {
    public static double p = 0.0;
    public static int low;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            int n = cin.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = cin.nextInt();
            }
            p = 0.0;
            low=(3*n+4)/5;
            dfs(a, 1.0, 0, 0);
            DecimalFormat df   = new DecimalFormat("0.000000");
            System.out.println(df.format(PassTest1.p));
        }
    }

    public static void dfs(int[] a, double p, int passCount, int index) {
        if(index == a.length) {
            if (passCount >= low)
                PassTest1.p += p;
            return;
        }
        dfs(a, p * a[index] / 100, passCount + 1, index + 1);
        dfs(a, p * (100.0 - a[index]) / 100, passCount, index + 1);
    }
}
