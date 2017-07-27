package DP;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by xwz on 4/11/17.
 *
 * 小明做N道题，只有做对60%的题才能通过。已知每道题小明答对的概率，求小明能通过考试的概率
 输入：第一行为n，表示n道题
 第二行为n个整数表示概率Pi，表示第i道题的正确率Pi%；
 输出：一个小数点后保留后六位的小数
 例：
 输入：4
 50 50 50 50
 输出：0.654675

 #include <bits/stdc++.h>
 #define maxn 109
 using namespace std;
 int n,a[maxn];
 double dp[maxn][maxn];
 int main(){
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
        scanf("%d",&a[i]);
    dp[0][0]=1;
    for(int i=1;i<=n;i++){
        dp[i][0]=dp[i-1][0]*(100.0-a[i])/100;
        for(int j=1;j<=i;j++)//dp[i][j]表示i道题做对j道题的概率，可以由i道题的前i-1道题做对了j道，第i道题没有做对和由i道题的前i-1道题做对了j-1道题，第i道题做对了的概率相加
            dp[i][j]=dp[i-1][j]*(100.0-a[i])/100+dp[i-1][j-1]*1.0*a[i]/100;
    }
    int low=(3*n+4)/5;
     double ans=0;
     for(int i=low;i<=n;i++)
     ans+=dp[n][i];
     printf("%.5f\n",ans);
     //system("pause");
     return 0;
 }

 */
public class PassTest {
    public static void main(String[] args) {
        int n;
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            n = cin.nextInt();
            int[] a = new int[n+1];
            for(int i = 1; i <= n; i++) {
                a[i] = cin.nextInt();
            }
            double[][] dp= new double[n+1][n+1];
            dp[0][0] = 1;
            for(int i = 1; i <= n; i++) {
                dp[i][0] = dp[i-1][0] * (100.0 - a[i]) / 100;
                for(int j = 1; j <= i; j++) {
                    dp[i][j] = dp[i-1][j] * (100.0 - a[i]) / 100 + dp[i - 1][j - 1] * 1.0 * a[i] / 100;
                }
            }
            int low = (3 * n + 4) / 5;
            double ans = 0;
            for(int i = low; i <= n; i++)
                ans += dp[n][i];
            DecimalFormat df   = new DecimalFormat("0.000000");
            System.out.println(df.format(ans));
        }
    }
}
