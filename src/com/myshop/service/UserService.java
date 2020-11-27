package com.myshop.service;

import com.myshop.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registerUser(User user);

    /**
     * 登录
     * @param user
     * @return null则登录失败，否则成功
     */
    public User loginUser(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return true表示已存在，false表示用户名可用
     */
    public boolean existsUsername(String username);
}
