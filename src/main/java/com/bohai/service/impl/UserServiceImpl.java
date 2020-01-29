package com.bohai.service.impl;

import com.bohai.dao.UserDao;
import com.bohai.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void save() {
        userDao.save();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
