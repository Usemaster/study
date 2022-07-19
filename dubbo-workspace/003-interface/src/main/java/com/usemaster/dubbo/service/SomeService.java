package com.usemaster.dubbo.service;

import com.usemaster.dubbo.model.User;

/**
 * @author gongwj
 * @Date 2022/6/6
 */
public interface SomeService {
    /**
     * Hello方法
     * @return
     */
    String hello();

    /**
     * 通过用户id查用户详情
     * @param id
     * @return
     */
    User queryUserById(Integer id);
}

