package com.example.demo.web;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@Controller
public class ShiroController {


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

    @RequestMapping({"/","/index"})
    public String index(HttpServletRequest request,Model model){
        return "index";
    }

    @RequestMapping(value = "/hello")
    @RequiresPermissions(value = {"1"})
    public String hello(HttpServletRequest request,Model model){
        return "hello";
    }

    @RequestMapping(value = "/aix")
    @RequiresPermissions(value = {"2"})
    public String aix(HttpServletRequest request,Model model){
        return "aix";
    }

}
