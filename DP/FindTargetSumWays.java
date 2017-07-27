package DP;


/**
 * Created by xwz on 4/10/17.
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 Find out how many ways to assign symbols to make sum of integers equal to target S.
 Example 1:
 Input: nums is [1, 1, 1, 1, 1], S is 3.
 Output: 5
 Explanation:

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 There are 5 ways to assign symbols to make the sum of nums be target 3.

 */
public class FindTargetSumWays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        if (nums == null || nums.length == 0)
            System.out.println(0);
        System.out.println(dfs(nums, S, 0, 0));
    }

    static int dfs(int[] nums, int S, int sum, int index) {
        if (index == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        }
        return dfs(nums, S, sum + nums[index], index + 1) + dfs(nums, S, sum - nums[index], index + 1);
    }
}
