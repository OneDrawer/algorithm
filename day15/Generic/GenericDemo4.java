package day15.Generic;

/**
 * Created by xwz on 8/22/16.
 * 调用自定义泛型类
 */
public class GenericDemo4 {
    public static void main(String[] args) {

        ObjectTool2 ot = new ObjectTool2();
        ot.show("hello world");
        ot.show(100);
        ot.show(true);
    }
}
