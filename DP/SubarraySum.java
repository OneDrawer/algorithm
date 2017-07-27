package DP;

/**
 * Created by xwz on 4/10/17.
 *
 * Given a list of non-negative numbers and a target integer k,
 * write a function to check if the array has a continuous subarray
 * of size at least 2 that sums up to the multiple of k, that is,
 * sums up to n*k where n is also an integer.

 Example 1:
 Input: [23, 2, 4, 6, 7],  k=6
 Output: True
 Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] arrays = {23, 2, 4, 6, 7};
        int n = 6;
        int size = arrays.length;
        for(int j = 0; j < size; j++) {
            int sum = 0;
            for (int k = j; k < size; k++) {
                sum += arrays[k];
                if (sum % n == 0 && k != j) {
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");
    }
}
