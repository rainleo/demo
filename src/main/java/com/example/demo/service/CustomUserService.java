package com.example.demo.service;

import com.example.demo.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public class CustomUserService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserDO user = userService.findUserByName(name);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("name:"+name);
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
    }
}