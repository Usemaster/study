package com.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.pojo.Comment;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kappy
 * @since 2021-06-14
 */
@Component("commentDao")
public interface CommentMapper extends BaseMapper<Comment> {

    //根据post的id数查询评论数
    int getCommentCounts(Long postId);

}
