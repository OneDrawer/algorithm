package Code;

/**
 * Created by xwz on 9/8/16.
 */
public abstract class AbstractImp implements InterfaceTest{
    private String s0 = "String0";

    @Override
    public void fun2() {
        System.out.println("abstract class fun2 " + s0);
    }

    @Override
    public void fun3() {
        System.out.println("abstract class fun3 " + ss);
    }

//    @Override
//    public void fun1() {
//        System.out.println("abstract class fun1");
//    }

    public abstract void abstractfun();
}
