package com.study.dao;

import com.study.pojo.User;


public interface UserMapper {

    //根据id查询用户
    User getUserById(int id);
}
