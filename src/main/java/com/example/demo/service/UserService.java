package com.example.demo.service;

import com.example.demo.domain.UserDO;

import java.util.List;


public interface UserService{

    int insert(UserDO pojo);

    List<UserDO> primaryListAll();

    List<UserDO> secondListAll();

    UserDO findUserById(String name);

    int update(UserDO userDO);
}
