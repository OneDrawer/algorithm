package DP;

/**
 * Created by xwz on 4/10/17.
 *
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have
 * security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money
 of each house, determine the maximum amount of money you can rob tonight
 without alerting the police.
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {10,2,4,5,6,8,5,6,9,3};
        if(nums.length == 0)
            System.out.print("0");
        if(nums.length == 1)
            System.out.print(nums[0]);
        if(nums.length == 2)
            System.out.println(nums[0] > nums[1] ? nums[0] : nums[1]);
        int[] maxValue = new int[nums.length];
        maxValue[0] = nums[0];
        maxValue[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        int size = nums.length;
        for(int i = 2; i < size; i++) {
            maxValue[i] = nums[i] + maxValue[i-2] > maxValue[i-1] ? nums[i] + maxValue[i-2] : maxValue[i-1];
        }
        System.out.println(maxValue[size -1]);
    }
}
