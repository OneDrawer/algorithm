package day14_Date_DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xwz on 8/19/16.
 */
public class DateFormatDemo {
    public static void main(String[] args) {
        //创建对象
        Date d = new Date();

        //创建格式化对象(默认模式)
        SimpleDateFormat sdf = new SimpleDateFormat();
        String s = sdf.format(d);
        System.out.println(s);

        //创建格式化对象(给定模式)
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String s2 = sdf2.format(d);
        System.out.println(s2);
    }
}
