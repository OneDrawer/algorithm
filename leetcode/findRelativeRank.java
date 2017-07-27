package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by xwz on 3/28/17.
 */
public class findRelativeRank {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1,8,9,12};
        int size = nums.length;
        int[] tmp = new int[size];
        for(int i = 0; i < size; i++) {
            tmp[i] = nums[i];
        }
        String[] res = new String[nums.length];
        Arrays.sort(tmp);
        HashMap<Integer, Integer> score2Rank = new HashMap<Integer, Integer>();
        int i = 0;
        while(i < size) {
            score2Rank.put(tmp[i], size - i);
            i++;
        }
        for(i = 0; i < size; i++) {
            if(score2Rank.get(nums[i]) == 1) {
                res[i] = "Gold Medal";
                continue;
            }
            if(score2Rank.get(nums[i]) == 2) {
                res[i] = "Silver Medal";
                continue;
            }
            if(score2Rank.get(nums[i]) == 3) {
                res[i] = "Bronze Medal";
                continue;
            }
            res[i] = String.valueOf(score2Rank.get(nums[i]));
        }


        for(i = 0; i < size; i++ ) {
            System.out.print(res[i] + " ");
        }
        //return res;
    }
    public static int getIndex(int value, int[] nu) {
        int size = nu.length;
        for(int i = 0; i < size; i++) {
            if(nu[i] == value)
                return i;
        }
        return -1;
    }

}
