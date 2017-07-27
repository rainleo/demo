package com.example.demo.web;

/**
 * security 登录权限控制demo
 * Created by niewenlong on 2017/7/24.
 * @EnableWebSecurity //(如果不配置在这里的话，会出现访问找不到Mapper方法名的情况)
 * @Controller (value = "SecurityController")
 */
public class SecurityController {
    /*
    //主页
    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }
    //登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    //hello页面
    //需要权限 1 或者 角色权限 @RequiresRoles(value = {"1"})
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    //aix页面
    //需要权限
    @RequestMapping(value = "/aix")
    @PreAuthorize("hasRole('ROLE_1')")
    public String aix(){
        return "aix";
    }
*/
}
