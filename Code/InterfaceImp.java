package Code;

/**
 * Created by xwz on 9/8/16.
 */
public class InterfaceImp extends AbstractImp{
    public InterfaceImp() {
    }


    @Override
    public void fun1() {
        System.out.println("InterfaceImp class fun1 " + ss);
    }

    @Override
    public void abstractfun() {
        System.out.println("InterfaceImp class abstracfun " + ss);
    }
}
