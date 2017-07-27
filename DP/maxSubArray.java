package DP;

/**
 * Created by xwz on 4/10/17.
 */
public class maxSubArray {
    public static void main(String[] args) {
        int[] arrys = {-2,1,-3,4,-1,2,1,-5,4};
        int maxValue = 0;
        int max = arrys[0];
        int size = arrys.length;
        for(int i = 0; i < size; i++) {
            if(maxValue > 0) {
                maxValue = maxValue + arrys[i];
            } else {
                maxValue = arrys[i];
            }
            if(maxValue > max) {
                max = maxValue;
            }
        }
        System.out.println(max);
    }
}
