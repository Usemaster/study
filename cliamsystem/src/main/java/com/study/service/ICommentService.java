package com.study.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.pojo.Comment;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kappy
 * @since 2021-06-14
 */
public interface ICommentService extends IService<Comment> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Comment>
     */
    IPage<Comment> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param comment 
     * @return int
     */
    int add(Comment comment);

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
     * @param comment 
     * @return int
     */
    int updateData(Comment comment);

    /**
     * id查询数据
     *
     * @param id id
     * @return Comment
     */
    Comment findById(Long id);

    //根据post的id数查询评论数
    int getCommentCounts(Long postId);
}
