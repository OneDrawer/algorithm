package day17.dao;

import day17.pojo.User;

/**
 * Created by xwz on 8/23/16.
 */
public interface UserDao {
    /**
     * 用户登录功能
     * @param username 用户名
     * @param password 密码
     * @return 返回登录是否成功
     */
    public abstract boolean isLogin(String username, String password);
    public abstract void regist(User user);
}
