package day15.Generic;

/**
 * Created by xwz on 8/22/16.
 */
public class GenericDemo3 {
    public static void main(String[] args) {
//        ObjectTool ot = new ObjectTool();
//        ot.show("hello");
//        ot.show(100);
//        ot.show(true);

        ObjectTool<String> ot1 = new ObjectTool<String>();
        ot1.show("hello world");

        ObjectTool<Integer> ot2 = new ObjectTool<Integer>();
        ot2.show(100);

        ObjectTool<Boolean> ot3 = new ObjectTool<Boolean>();
        ot3.show(true);
    }
}
