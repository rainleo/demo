package com.example.demo.web;

import com.example.demo.domain.UserDO;
import com.example.demo.exception.MyException;
import com.example.demo.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * Created by niewenlong on 2017/5/23.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;


    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = false, dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "age", value = "密码", required = true, dataType = "int",paramType = "query")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "results", response = String.class)
    })
    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String postUser() throws MyException {
        UserDO user = new UserDO();
        user.setName("jin1");
        user.setAge(25);
        return (userService.primaryListAll().get(0).toString() + userService.secondListAll().get(0).toString());
    }

}