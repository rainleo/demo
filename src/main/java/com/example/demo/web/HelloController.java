package com.example.demo.web;

import com.example.demo.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by niewenlong on 2017/5/23.
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com1");
        // return模板文件的名称，对应src/main/resources/templates/index.vm
        return "index";
    }
    @RequestMapping("/hello")
    public String hello() throws Exception{
        throw new Exception("发生错误");
    }
    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

}
