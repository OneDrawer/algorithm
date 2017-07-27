package day14_Date_DateFormat;

import java.util.Date;

/**
 * Created by xwz on 8/19/16.
 */
public class DateDemo {
    public static void main(String[] args) {
        Date d = new Date();

        //getTime()
        long time = d.getTime();
        System.out.println(time);
//        System.out.println(System.currentTimeMillis());

        //setTime()
        System.out.println("d:" + d);
        d.setTime(System.currentTimeMillis());
        System.out.println("d:" + d);
    }
}
