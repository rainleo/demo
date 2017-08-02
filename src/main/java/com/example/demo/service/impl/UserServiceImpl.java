package com.example.demo.service.impl;

import com.example.demo.config.redisConfig.RedisService;
import com.example.demo.dao.primary.PrimaryUserDao;
import com.example.demo.domain.UserDO;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private PrimaryUserDao primaryUserDao;
    @Resource
    private RedisService redisService;

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
    public List<UserDO> findByName(String name) {
        Map<String, UserDO> userDOMap = (Map<String, UserDO>) redisService.getCacheMap("user:");
        if (userDOMap == null || userDOMap.size() == 0) {
            List<UserDO> userDOList = primaryUserDao.findByName(name);
            for (UserDO userDO : userDOList) {
                userDOMap.put("id:" + userDO.getId(), userDO);
            }
            redisService.setCacheMap("user:", userDOMap);
        }
        System.out.println(userDOMap);
        return null;
    }
}
