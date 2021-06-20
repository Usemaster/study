package com.study.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.dao.CommentMapper;
import com.study.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kappy
 * @since 2021-06-14
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Autowired
    private CommentMapper commentDao;

    @Override
    public  IPage<Comment> findListByPage(Integer page, Integer pageCount){
        IPage<Comment> wherePage = new Page<>(page, pageCount);
        Comment where = new Comment();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Comment comment){
        return baseMapper.insert(comment);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Comment comment){
        return baseMapper.updateById(comment);
    }

    @Override
    public Comment findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public int getCommentCounts(Long postId) {
        return commentDao.getCommentCounts(postId);
    }
}
