package com.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kappy
 * @since 2021-06-14
 */
@Component("userDao")
public interface UserMapper extends BaseMapper<User> {

    /**
    * 查询用户列表
     */
    List<User> queryList(User user);

    /**
    * 根据用户名 密码获取用户名对象
     */
    User queryUserByNameAndPwd(@Param("username") String username,
                               @Param("password") String password);

    User queryUserByName(@Param("username") String username);
}
