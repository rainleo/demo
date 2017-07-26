package com.example.demo.service.impl;

import com.example.demo.dao.primary.PrimaryUserDao;
import com.example.demo.domain.UserDO;
import com.example.demo.service.UserService;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private PrimaryUserDao primaryUserDao;

    public int insert(UserDO pojo){
        return primaryUserDao.insert(pojo);
    }

    public int insertSelective(UserDO pojo){
        return primaryUserDao.insertSelective(pojo);
    }

    public int insertList(List<UserDO> pojos){
        return primaryUserDao.insertList(pojos);
    }

    public int update(UserDO pojo){
        return primaryUserDao.update(pojo);
    }

    @Override
    public UserDO findByName(String name) {
        return primaryUserDao.findByName(name);
    }
}
