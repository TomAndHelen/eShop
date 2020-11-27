package com.myshop.test;

import com.myshop.pojo.User;
import com.myshop.service.UserService;
import com.myshop.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {


    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User(null, "abc", "abc", "abc@qq.com"));
    }

    @Test
    public void loginUser() {
        if (userService.loginUser(new User(null, "user1", "121212", "123")) == null){
            System.out.println("登录失败");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void existUsername() {
        if (userService.existsUsername("abcd") == true){
            System.out.println("用户名已存在");
        } else {
            System.out.println("用户名可使用");
        }
    }
}