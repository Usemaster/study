package com.study.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.study.pojo.Post;
import com.study.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kappy
 * @since 2021-06-14
 */
public interface IPostService extends IService<Post> {

    PageInfo<Post> findAll(int page, int pageSize, Post post);

    //根据状态查询具体的信息数量
    int getCountsByFlagAndStatus(Integer flag,Integer status);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Post>
     */
    IPage<Post> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param post 
     * @return int
     */
    int add(Post post);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param post 
     * @return int
     */
    int updateData(Post post);

    /**
     * id查询数据
     *
     * @param id id
     * @return Post
     */
    Post findById(Long id);


}
