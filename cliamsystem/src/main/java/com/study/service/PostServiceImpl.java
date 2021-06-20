package com.study.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.dao.PostMapper;
import com.study.pojo.Feedback;
import com.study.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kappy
 * @since 2021-06-14
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

    @Autowired
    private PostMapper postDao;

    @Override
    public PageInfo<Post> findAll(int page, int pageSize, Post post) {
        PageHelper.startPage(page,pageSize);
        List<Post> list = postDao.queryList(post);
        PageInfo<Post> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int getCountsByFlagAndStatus(Integer flag, Integer status) {
        return postDao.getCountsByFlagAndStatus(flag,status);
    }

    @Override
    public  IPage<Post> findListByPage(Integer page, Integer pageCount){
        IPage<Post> wherePage = new Page<>(page, pageCount);
        Post where = new Post();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Post post){
        return baseMapper.insert(post);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Post post){
        return baseMapper.updateById(post);
    }

    @Override
    public Post findById(Long id){
        return  postDao.getInfoById(id);
    }

}
