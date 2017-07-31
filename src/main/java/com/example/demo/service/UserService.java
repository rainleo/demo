package com.example.demo.service;

import com.example.demo.domain.UserDO;

import java.util.List;


public interface UserService {


    int insert(UserDO pojo);

    int insertSelective(UserDO pojo);

    int insertList(List<UserDO> pojos);

    int update(UserDO pojo);

    List<UserDO> findByName(String name);

}
