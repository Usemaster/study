package com.study.dao;

import com.study.pojo.User;
import com.study.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

;


public class UserDaoTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        List<User> users = mapper.getUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }

        User userByID = mapper.getUserByID(1);

        System.out.println(userByID);

        sqlSession.close();
    }


}
