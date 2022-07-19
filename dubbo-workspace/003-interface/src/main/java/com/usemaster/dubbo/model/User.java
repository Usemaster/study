package com.usemaster.dubbo.model;

import java.io.Serializable;

/**
 * @author gongwj
 * @Date 2022/6/6
 */
public class User implements Serializable {

    private Integer id;

    private String username;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
