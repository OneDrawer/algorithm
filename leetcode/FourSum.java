package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xwz on 9/28/16.
 */
public class FourSum {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,-3,-2,9,5,-1};
//        int [] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {0,0,0,0};
        int[] nums = {0, -2, -1, 0, 1, 2};
        List<List<Integer>> resultlist = new ArrayList();
        int target = 0;
        resultlist = threeSum(nums, target);
        for(List list1 : resultlist) {
            System.out.print("[");
            for (Object i : list1) {
                System.out.print(i + " ");
            }
            System.out.println("]");
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList();
        //考虑数组长度小于4的情况
        if(nums.length < 4) {
            return list;
        }

        //对数组进行一次从小到大的排序
        Arrays.sort(nums);

        //定义第一个数的索引,从0开始
        int first = 0;
        while(first < nums.length - 3) {
            //定义第二个索引,从first的下一个索引数开始
            int second = first + 1;
            while (second < nums.length - 2) {
                //定义第三个数的索引,从second的下一个数开始
                int third = second + 1;
                int four = nums.length - 1;
                while (third < four) {
                    int sum = nums[first] + nums[second] + nums[third] + nums[four];
                    // 第一种情况,4个数相加刚好等于0,则将4个数转换成列表后加到list中
                    if (sum == target) {
                        list.add(Arrays.asList(nums[first], nums[second], nums[third], nums[four]));
                        while (nums[third] == nums[++third] && third < four) {
                        }
                        while (nums[four] == nums[--four] && third < four) {
                        }
                        //break;
                    }
                    //第二种情况,4个数相加小于0,则将third往大的方向移,直到不等它本身即表示增大了
                    if (sum < target) {
                        while (nums[third] == nums[++third] && third < four) {
                        }
                    }
                    //第三种情况,4个数相加大于0,则可以将第4个往前移,使其变小
                    if (sum > target) {
                        while (nums[four] == nums[--four] && third < four) {
                        }
                    }
                }
                while(nums[second] == nums[++second] && second < nums.length - 2) {}
            }
            //忽略四个数中第一个数前面相同的数
            while (nums[first] == nums[++first] && first < nums.length - 3) {
            }
        }

        return list;
    }
}
