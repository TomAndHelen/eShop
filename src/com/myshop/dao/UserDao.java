package com.myshop.dao;

import com.myshop.pojo.User;

public interface UserDao{
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return null无，其他有
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return null说明账号密码错误，其他有
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息到数据库
     * @param user
     * @return 返回-1则保存失败，否则返回sql语句影响的行数
     */
    public int saveUser(User user);


}
