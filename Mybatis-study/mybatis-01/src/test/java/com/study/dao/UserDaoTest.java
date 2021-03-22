package com.study.dao;

import com.study.pojo.User;
import com.study.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //第一步获取SqlSession对象
        SqlSession sqlSesion = MybatisUtils.getSqlSesion();

        //方式一：getMapper
        UserDao userDao = sqlSesion.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSesion.close();
    }
}
