package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by niewenlong on 2017/7/24.
 */
@Controller
public class SecurityController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) throws Exception {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap map) throws Exception {
        map.addAttribute("host", "http://blog.didispace.com");
        return "hello";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
