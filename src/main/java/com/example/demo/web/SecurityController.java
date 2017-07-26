package com.example.demo.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 登录权限控制demo
 * Created by niewenlong on 2017/7/24.
 */

@RestController(value = "SecurityController")
public class SecurityController {


    //主页
    @RequestMapping({"/","/index"})
    public String index(HttpServletRequest request,Model model){
        return "index";
    }
    //登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request,Model model){
        return "login";
    }

    //hello页面
    //需要权限 1 或者 角色权限 @RequiresRoles(value = {"1"})
    @RequestMapping(value = "/hello")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String hello(HttpServletRequest request,Model model){
        return "hello";
    }

    //aix页面
    //需要权限
    @RequestMapping(value = "/aix")
    public String aix(HttpServletRequest request,Model model){
        return "aix";
    }

}
