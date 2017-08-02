package com.example.demo.web;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.UserDO;
import com.example.demo.exception.MyException;
import com.example.demo.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by niewenlong on 2017/5/23.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;


    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = false, dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "age", value = "密码", required = true, dataType = "int",paramType = "query")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "results", response = String.class)
    })
    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public JSONObject createUser() throws MyException {
        UserDO user = new UserDO();
        user.setName("niewenlong");
        user.setPassword("niewenlong");
        userService.insert(user);
        List<UserDO> userDOList = userService.findByName("niewenlong");
        JSONObject needJson = new JSONObject();
        needJson.put("list",userDOList);
        return needJson;
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public JSONObject findByName() throws MyException {
        List<UserDO> userDOList = userService.findByName("niewenlong");
        JSONObject needJson = new JSONObject();
        needJson.put("list",userDOList);
        return needJson;
    }


}