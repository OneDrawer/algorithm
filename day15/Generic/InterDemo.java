package day15.Generic;

/**
 * Created by xwz on 8/22/16.
 * 自定义泛型接口,实现泛型接口,使用泛型接口
 */
public class InterDemo {
    public static void main(String[] args) {
        //第一种情况
        Inter<String> i = new InterImpl<String>();
        i.show("hello world");

        Inter<Integer> ii = new InterImpl<Integer>();
        ii.show(100);


    }
}
