package com.example.demo.dao.primary;

import com.example.demo.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PrimaryUserDao {
    int insert(@Param("pojo") UserDO pojo);

    int insertSelective(@Param("pojo") UserDO pojo);

    int insertList(@Param("pojos") List<UserDO> pojo);

    int update(@Param("pojo") UserDO pojo);

    List<UserDO> findByName(@Param("name")String name);




}
