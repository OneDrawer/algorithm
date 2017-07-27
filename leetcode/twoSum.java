package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xwz on 3/28/17.
 */
public class twoSum {
    public static void main(String[] args) {
        int[] numbers = {2,3,4};
        int target = 6;
        List<Integer> l = new ArrayList<Integer>();
        int begin = 0;
        int end = numbers.length - 1;
        while(begin < end) {
            if(numbers[begin] + numbers[end] > target) {
                end--;
            }
            if(numbers[begin] + numbers[end] < target) {
                begin++;
            }
            if(numbers[begin] + numbers[end] == target) {
                l.add(begin+1);
                l.add(end+1);
                begin++;
                end--;
            }
        }
        int[] res = new int[l.size()];
        int i = 0;
        int size = l.size();
        while(i < size) {
            res[i] = l.get(i);
            i++;
        }
        for( i = 0; i < size; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
