package Code;

import java.util.Scanner;

/**
 * Created by xwz on 3/29/17.
 */
public class wanmei2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            int n = cin.nextInt();
            int[] value = new int[n];
            int[] weight = new int[n];
            for(int i = 0; i < n; i++) {
                value[i] = cin.nextInt();
            }
            for(int i = 0; i < n; i++) {
                weight[i] = cin.nextInt();
            }
            int W = cin.nextInt();
            int[][] c = new int[n+1][W+1];
            System.out.println(Dp(n, W, c, value, weight));
        }
    }

    public static int Dp(int n, int W, int[][] c, int[] value, int[] weight) {
        for(int i = 1; i <= n; i++) {
            c[i][0] = 0;
            for(int w = 1; w <= W; w++) {
                if(weight[i-1] > w) {
                    c[i][w] = c[i - 1][w];
                } else {
                    int tmp = c[i-1][w-weight[i-1]] +  value[i-1];
                    if(c[i-1][w] > tmp) {
                        c[i][w] = c[i-1][w];
                    } else {
                        c[i][w] = tmp;
                    }
                }
            }
        }
        return c[n][W];
    }

}
