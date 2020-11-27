package com.myshop.service.impl;

import com.myshop.dao.UserDao;
import com.myshop.dao.impl.UserDaoImpl;
import com.myshop.pojo.User;
import com.myshop.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();
    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User loginUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        return userDao.queryUserByUsernameAndPassword(username, password);

    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            return false;
        }

        return true;

    }
}
