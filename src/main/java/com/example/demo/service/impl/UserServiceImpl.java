package com.example.demo.service.impl;

import com.example.demo.dao.primary.PrimaryUserDao;
import com.example.demo.dao.second.SecondUserDao;
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
    private PrimaryUserDao primaryPrimaryUserDao;
    @Autowired
    private SecondUserDao secondSecondUserDao;

    public int insert(UserDO pojo) {
        int i = primaryPrimaryUserDao.insert(pojo);
        int i1 = secondSecondUserDao.insert(pojo);
        return i + i1;
    }

    public List<UserDO> listAll() {
        List<UserDO> userDBList = primaryPrimaryUserDao.listAll();
        return userDBList;
    }

    public UserDO findUserById(String name){
        return primaryPrimaryUserDao.findUserById(name);
    }

    @Override
    public int update(UserDO userDO) {
        return primaryPrimaryUserDao.update(userDO);
    }

}
