package com.example.demo.dao.second;

import com.example.demo.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SecondUserDao {
    int insert(@Param("pojo") UserDO pojo);

    int insertSelective(@Param("pojo") UserDO pojo);

    int insertList(@Param("pojos") List<UserDO> pojo);

    int update(@Param("pojo") UserDO pojo);

    List<UserDO> listAll();

    UserDO findUserById(@Param("name") String name);

}
