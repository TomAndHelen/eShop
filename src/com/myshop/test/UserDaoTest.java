//package com.myshop.test;
//
//import com.myshop.dao.UserDao;
//import com.myshop.dao.impl.UserDaoImpl;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class UserDaoTest {
//
//    UserDao userDao = new UserDaoImpl();
//    @Test
//    public void queryUserByUsername() {
//        if (userDao.queryUserByUsername("admin") == null) {
//            System.out.println("用户名可用");
//        } else {
//            System.out.println("用户名不可用");
//        }
//    }
//
//    @Test
//    public void queryUserByUsernameAndPassword() {
//    }
//
//    @Test
//    public void saveUser() {
//    }
//}


package com.myshop.test;

import com.myshop.dao.UserDao;
import com.myshop.dao.impl.UserDaoImpl;
import com.myshop.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        if (userDao.queryUserByUsername("admin") == null ){
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if ( userDao.queryUserByUsernameAndPassword("admin","in") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println( userDao.saveUser(new User(null,"xiaojuanrou", "123456", "xjr@qq.com")) );
    }
}