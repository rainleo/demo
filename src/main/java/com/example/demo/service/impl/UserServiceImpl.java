package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.UserDO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by niewenlong-work on 2017/5/24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @CacheEvict(value = "userCache", allEntries = true)
    public int insert(UserDO pojo){
        int i = userDao.insert(pojo);//非高并发1234
        //<editor-fold desc="redisTemplate">
        /*if(i > 0){
            redisTemplate.delete("user:");
            redisTemplate.opsForValue().set("user:",userDao.listAll());
        }*/
        //</editor-fold>
        return i;
    }

    @Cacheable(value = "userCache",keyGenerator = "wiselyKeyGenerator")
    public List<UserDO> listAll() {
        //<editor-fold desc="redisTemplate">
        /*String key = "user:";
        List<UserDO> userDoList = (List<UserDO>)redisTemplate.opsForValue().get("user:");
        if(userDoList != null){
            System.out.println("走的缓存");
            return userDoList;
        }
        System.out.println("走的db");
        List<UserDO> userDBList = userDao.listAll();
        redisTemplate.opsForValue().set(key,userDBList);
        return userDBList;*/
        //</editor-fold>
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
