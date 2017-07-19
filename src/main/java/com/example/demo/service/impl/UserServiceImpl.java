package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.UserDO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by niewenlong-work on 2017/5/24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public int insert(UserDO pojo){
        int i = userDao.insert(pojo);
        return i;
    }

    public List<UserDO> listAll() {
        List<UserDO> userDBList = userDao.listAll();
        return userDBList;
    }

    public UserDO findUserById(String name){
        return userDao.findUserById(name);
    }

    @Override
    public int update(UserDO userDO) {
        return userDao.update(userDO);
    }

}
