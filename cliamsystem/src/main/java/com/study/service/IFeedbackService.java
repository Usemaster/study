package com.study.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.study.pojo.Feedback;
import com.study.pojo.Type;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kappy
 * @since 2021-06-14
 */
public interface IFeedbackService extends IService<Feedback> {

    /**
     * 分页查询
     */
    PageInfo<Feedback> findAll(int page, int pageSize, String title);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Feedback>
     */
    IPage<Feedback> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param feedback 
     * @return int
     */
    int add(Feedback feedback);

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
     * @param feedback 
     * @return int
     */
    int updateData(Feedback feedback);

    /**
     * id查询数据
     *
     * @param id id
     * @return Feedback
     */
    Feedback findById(Long id);
}
