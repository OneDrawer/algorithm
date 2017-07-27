package Code;

/**
 * Created by xwz on 9/8/16.
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        InterfaceImp ii = new InterfaceImp();
        ii.fun1();
        ii.fun2();
        ii.fun3();
        ii.abstractfun();

        System.out.println("--------------");

        InterfaceTest it = new InterfaceImp();
        it.fun1();
        InterfaceImp it2 = (InterfaceImp) it;//向下转型
        it2.fun1();

        System.out.println("----------------");
        AbstractImp ai = new InterfaceImp();
        ai.abstractfun();
        InterfaceImp ii2 = (InterfaceImp) ai;//向下转型
        ii2.abstractfun();
        InterfaceTest it3 = (InterfaceTest) ii2;//向上转型
        it3.fun1();
    }
}
