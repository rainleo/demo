package com.example.demo.service;

import com.example.demo.domain.UserDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


public interface UserService {


    int insert(UserDO pojo);

    int insertSelective(UserDO pojo);

    int insertList(List<UserDO> pojos);

    int update(UserDO pojo);

    UserDO findByName(String name);

}
