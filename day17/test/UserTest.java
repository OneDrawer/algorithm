package day17.test;

import day17.dao.UserDao;
import day17.dao.impl.UserDaoImpl;
import day17.pojo.User;

import java.util.Scanner;

/**
 * Created by xwz on 8/23/16.
 * 用户测试类
 */
public class UserTest {
    public static void main(String[] args) {
        while (true) {
            System.out.println("--------------欢迎光临------------");
            System.out.println("1登录");
            System.out.println("2注册");
            System.out.println("3退出");

            System.out.println("please input you choice:");
            Scanner sc = new Scanner(System.in);
            String choiceString = sc.nextLine();
            UserDao ud = new UserDaoImpl();
            //经过简单的思考 我选择了switch
            switch (Integer.parseInt(choiceString)) {
                case 1:
                    //登录界面,请输入用户名和密码
                    System.out.println("-------------登录界面--------------");
                    System.out.println("请输入用户名:");
                    String username = sc.nextLine();
                    System.out.println("请输入密码:");
                    String password = sc.nextLine();

                    //调用登录功能
                    boolean flag = ud.isLogin(username, password);
                    if (flag) {
                        System.out.println("登录成功");
                        System.exit(0);
                    } else {
                        System.out.println("用户名或者密码有误,登录失败");
                    }
                    break;
                case 2:
                    //欢迎界面,请输入用户名和密码
                    System.out.println("-------------注册界面--------------");
                    System.out.println("请输入用户名:");
                    String newUsername = sc.nextLine();
                    System.out.println("请输入密码:");
                    String newPassword = sc.nextLine();

                    //把用户名和密码封装到一个对象中
                    User user = new User();
                    user.setUsername(newUsername);
                    user.setPassword(newPassword);
                    //调用注册功能

                    ud.regist(user);
                    System.out.println("注册成功");
                    break;
                case 3:

                default:
                    System.out.println("welcome next time");
                    System.exit(0);
                    break;
            }
        }
    }
}
