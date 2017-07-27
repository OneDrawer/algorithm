package day15.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xwz on 8/23/16.
 */
public class ArrayListDemo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> array = new ArrayList<Integer>();

        while (true) {
            System.out.println("please input data:");
            int number = sc.nextInt();
            if (number != 0) {
                array.add(number);
            } else {
                break;
            }
        }

        Integer[] i = new Integer[array.size()];
        array.toArray(i);
        Arrays.sort(i);
        System.out.println("The array is:" + arrayToString(i) + "the max value is:" + i[i.length - 1]);
    }

    public static String arrayToString(Integer[] i) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int x = 0; x < i.length; x++) {
            if(x == i.length - 1) {
                sb.append(i[x]);
            } else {
                sb.append(i[x] + ",");
            }
        }
        return sb.toString();
    }
}
