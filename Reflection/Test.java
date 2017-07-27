package Reflection;

import java.lang.reflect.Proxy;

/**
 * Created by xwz on 12/4/16.
 */
public class Test {
    public static void main(String[] args) {
        StudentDao sd = new StudentDaoImpl();
        MyInvocationHandler handler = new MyInvocationHandler(sd);
        StudentDao proxy = (StudentDao) Proxy.newProxyInstance(sd.getClass()
                .getClassLoader(), sd.getClass().getInterfaces(), handler);
        proxy.login();
        proxy.regist();
    }
}
