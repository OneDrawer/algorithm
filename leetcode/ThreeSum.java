package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xwz on 9/27/16.
 */
public class ThreeSum {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,-3,-2,9,5,-1};
//        int [] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0,0,0,0};
        List<List<Integer>> resultlist = new ArrayList();
        resultlist = threeSum(nums);
        for(List list1 : resultlist) {
            System.out.print("[");
            for (Object i : list1) {
                System.out.print(i + " ");
            }
            System.out.println("]");
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        //考虑数组长度小于3的情况
        if(nums.length < 3) {
            return list;
        }

        //对数组进行一次从小到大的排序
        Arrays.sort(nums);
//        if(nums[0] > 0) {
//            return list;
//        }
        //定义第一个数的索引,从0开始
        int first = 0;
        while(first < nums.length - 2) {
            //若是有序数的第一数大于0,则不可能出现三个数加起来等于的情况
            if(nums[first] > 0) {
                break;
            }
            //定义第二个索引,从i的下一个索引数开始
            int second = first + 1;
            //定义第三个数的索引,从最后一个数开始
            int third = nums.length - 1;
            while(second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                // 第一种情况,三个数相加刚好等于0,则将三个数转换成列表后加到list中
                if(sum == 0) {
                    list.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    while(nums[second] == nums[++second] && second < third) {}
                    while(nums[third] == nums[--third] && second < third) {}
                    //break;
                }
                //第二种情况,三个数相加小于0,则将中间的数往大的方向移,直到不等它本身即表示增大了
                if(sum < 0) {
                    while(nums[second] == nums[++second] && second < third) {}
                }
                //第三种情况,三个数相加大于0,则可以将第三个往前移,使其变小
                if(sum > 0) {
                    while(nums[third] == nums[--third] && second < third) {}
                }
            }
            //忽略三个数中第一个数前面相同的数
            while(nums[first] == nums[++first] && first < nums.length - 2) {}
        }

        return list;
    }
}


