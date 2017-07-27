package day17.dao.impl;

import day17.dao.UserDao;
import day17.pojo.User;

import java.util.ArrayList;

/**
 * Created by xwz on 8/23/16.
 */
public class UserDaoImpl implements UserDao {
    private static ArrayList<User> array = new ArrayList<User>();

    @Override
    public boolean isLogin(String username, String password) {
        //遍历集合,获取一个用户,并判断该用户的用户名和密码是否和传递过来的匹配
        boolean flag = false;
        for(User u : array) {
            if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public void regist(User user) {
//        ArrayList<User> array = new ArrayList<User>();
        array.add(user);
    }
}
