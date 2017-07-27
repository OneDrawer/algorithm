package Reflection;

/**
 * Created by xwz on 12/4/16.
 */
public class StudentDaoImpl implements StudentDao{
    @Override
    public void login() {
        System.out.println("登录功能");
    }

    @Override
    public void regist() {
        System.out.println("注册功能");
    }
}
