package day15.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Created by xwz on 8/20/16.
 */
public class ListDemo9 {
    public static void main(String[] args) {
        //Arraylist()
        List arrList = new ArrayList();
        long startTime1 = System.currentTimeMillis();
        for(int x = 0; x < 10000000; x++) {
            arrList.add("hello" + x);
        }
//        System.out.println(arrList);
        long endTime1 = System.currentTimeMillis();
        System.out.println("startTime1 - endTime1:" + (endTime1 - startTime1));


        //Vertor()
        List arrList2 = new Vector();
        long startTime2 = System.currentTimeMillis();
        for(int x = 0; x < 10000000; x++) {
            arrList2.add("java" + x);
        }
//        System.out.println(arrList2);
        long endTime2 = System.currentTimeMillis();
        System.out.println("startTime2 - endTime2:" + (endTime2 - startTime2));

        //LinkedList()
        List arrList3 = new LinkedList();
        long startTime3 = System.currentTimeMillis();
        for(int x = 0; x < 10000000; x++) {
            arrList3.add("java" + x);
        }
//        System.out.println(arrList3);
        long endTime3 = System.currentTimeMillis();
        System.out.println("startTime3 - endTime3:" + (endTime3 - startTime3));
//        System.out.println("startTime2 - endTime2:" + (endTime2 - startTime2));
    }
}
