package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xwz on 9/11/16.
 */
public class lengthOfLastWord {
    public static void main(String[] args) {
        String s = "hello world java";
        s = s.trim();
//        List<String> list = new ArrayList<>();
        String[] arrayStr = new String[] {};

        arrayStr = s.split(" ");
        System.out.println(arrayStr[arrayStr.length - 1].length());
//        list = Arrays.asList(arrayStr);
//        System.out.println();
    }
}
