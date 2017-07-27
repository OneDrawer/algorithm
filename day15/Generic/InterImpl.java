package day15.Generic;

/**
 * Created by xwz on 8/22/16.
 * 实现泛型接口
 */
public class InterImpl<T> implements Inter<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
/*第二种情况
public class InterImp implements Inter<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}*/
