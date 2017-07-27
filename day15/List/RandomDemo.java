package day15.List;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by xwz on 8/23/16.
 */
public class RandomDemo {
    public static void main(String[] args) {
        Random r = new Random();

        ArrayList<Integer> array = new ArrayList<Integer>();

        int count = 0;
        while(count < 10) {
            int number = r.nextInt(20) + 1;
            if(!array.contains(number)) {
                array.add(number);
                count++;
            }
        }

        for(Integer i : array) {
            System.out.println(i);
        }
    }
}
