package com.study.dao;

import com.study.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //insert一个用户
    int addUser(User user);

    User selectUserByNP2(Map<String,Object> map);

    //修改一个用户
    int updateUser(User user);

    //删除一个用户
    int deleteUser(int id);
}
