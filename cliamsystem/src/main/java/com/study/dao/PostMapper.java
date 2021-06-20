package com.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.pojo.Post;
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
@Component("postDao")
public interface PostMapper extends BaseMapper<Post> {

    //多条件查询失物列表信息
    List<Post> queryList(Post post);

    //根据状态查询具体的信息数量
    int getCountsByFlagAndStatus(@Param("flag") Integer flag, @Param("status")Integer status);

    //根据id后去post对象
    Post getInfoById(Long id);

}
