package Exception;

/**
 * Created by xwz on 8/26/16.
 *
 * 1. final, finally, finalize的区别
 * final:最终的意思, 可以修饰类, 成员变量,成员方法
 *      修饰类, 类不能被继承
 *      修饰变量,变量是常量
 *      修饰方法, 方法不能被重写
 * finally: 是异常处理的一部分,用于释放资源
 *      一般来说代码肯定会执行,特殊情况:在执行到finally之前jvm退出了
 * finalize: 是object的一个方法, 用于垃圾回收
 *
 *
 * 2.如果catch里面有return语句,请问finally里面的代码还会执行吗?
 *     如果会,请问是在return前,还是后。
 *     会、前。
 *
 */
public class FinallyDemo2 {
    public static void main(String[] args) {
        System.out.println(getInt());
    }

    public static int getInt() {
        int a = 10;
        try{
            System.out.println(a/0);
            a = 20;
        } catch (ArithmeticException e) {
            a = 30;
            return a;
        } finally {
            a = 40;
        }
        return a;
    }
}
