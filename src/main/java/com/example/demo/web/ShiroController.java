package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 登录权限控制demo
 * Created by niewenlong on 2017/7/24.
 */
//@Controller(value = "LoginController")
public class ShiroController {/*

    //登录页(shiro配置需要两个/login 接口,一个是get用来获取登陆页面,一个用post用于登录,这是一个坑)
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
        Object exception = request.getAttribute("shiroLoginFailure");
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "提示->账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "提示->密码不正确";
            } else {
                msg = "提示->未知错误";
            }
            map.put("msg", msg);
            return "login";
        }
        //如果已经登录，直接跳转主页面
        return "index";
    }
    //主页
    @RequestMapping({"/","/index"})
    public String index(HttpServletRequest request,Model model){
        return "index";
    }

    //hello页面
    //需要权限 1 或者 角色权限 @RequiresRoles(value = {"1"})
    @RequestMapping(value = "/hello")
    @RequiresPermissions(value = {"1"})
    public String hello(HttpServletRequest request,Model model){
        return "hello";
    }

    //aix页面
    //需要权限
    @RequestMapping(value = "/aix")
    @RequiresPermissions(value = {"1"})
    public String aix(HttpServletRequest request,Model model){
        return "aix";
    }
*/
}
