package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by niewenlong on 2017/5/23.
 */
public class UserDO implements Serializable {

    private Long id;
    private String name;
    private String password;
    private Integer roleId;

    public String getPassword() {
        return password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public UserDO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDO(Long id, String name, String password, Integer roleId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                '}';
    }

}
