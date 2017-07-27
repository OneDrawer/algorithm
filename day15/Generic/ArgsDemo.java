package day15.Generic;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by xwz on 8/22/16.
 * 可变参数 sum(int...a)
 */
public class ArgsDemo {
    public static void main(String[] args) {
        int result = sum(20, 10);
        System.out.println(result);
        result = sum(20, 10, 30);
        System.out.println(result);
        result = sum(20, 10, 30, 40);
        System.out.println(result);
        result = sum(20, 10, 30, 40, 50);
        System.out.println(result);
        result = sum(20, 10, 30, 40, 50 ,60);
        System.out.println(result);


    }

    public static int sum(int... a) {
        int s = 0;
        for (int x : a) {
            s += x;
        }
        return s;
    }
}
