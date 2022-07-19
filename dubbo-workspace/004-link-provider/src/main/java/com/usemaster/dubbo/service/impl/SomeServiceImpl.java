package com.usemaster.dubbo.service.impl;

import com.usemaster.dubbo.model.User;
import com.usemaster.dubbo.service.SomeService;

/**
 * @author gongwj
 * @Date 2022/6/7
 */
public class SomeServiceImpl implements SomeService {


    @Override
    public String hello() {
        return "Hello Dubbo";
    }

    @Override
    public User queryUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("zhangsan" + id);
        return user;
    }
}
