package com.study.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.dao.FeedbackMapper;
import com.study.pojo.Feedback;
import com.study.pojo.Type;
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
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements IFeedbackService {

    @Autowired
    private FeedbackMapper feedbackDao;

    @Override
    public PageInfo<Feedback> findAll(int page, int pageSize, String title) {
        PageHelper.startPage(page,pageSize);
        List<Feedback> list = feedbackDao.queryList(title);
        PageInfo<Feedback> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public  IPage<Feedback> findListByPage(Integer page, Integer pageCount){
        IPage<Feedback> wherePage = new Page<>(page, pageCount);
        Feedback where = new Feedback();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Feedback feedback){
        return baseMapper.insert(feedback);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Feedback feedback){
        return baseMapper.updateById(feedback);
    }

    @Override
    public Feedback findById(Long id){
        return  baseMapper.selectById(id);
    }
}
