package DP;

/**
 * Created by xwz on 4/10/17.
 *
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.

 Example 1:
 Input:

 "bbbab"
 Output:
 4
 One possible longest palindromic subsequence is "bbbb".
 Example 2:
 Input:

 "cbbd"
 Output:
 2
 One possible longest palindromic subsequence is "bb".
 */
public class LongestPalindromeSubseq {
    public static void main(String[] args) {
        String s = "bbbab";
        int size = s.length();
        int[][] dp = new int[size][size];
        for(int i = 0; i < size; i++) {
            dp[i][i] = 1;
        }

        for(int i = 1; i < size; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    //dp[j][i]表示s的第j个字符到第i个字符的回文子序列的多少
                    dp[j][i] = j + 1 <= i - 1 ? dp[j + 1][i - 1] + 2 : 2;
                } else {
                    dp[j][i] = dp[j][i - 1] > dp[j + 1][i] ? dp[j][i - 1] : dp[j + 1][i];
                }
            }
        }
        System.out.println(dp[0][size - 1]);
    }
}
