package com.study.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.study.pojo.Notice;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kappy
 * @since 2021-01-07
 */
public interface INoticeService extends IService<Notice> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Notice>
     */
    IPage<Notice> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param notice
     * @return int
     */
    int add(Notice notice);

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
     * @param notice
     * @return int
     */
    int updateData(Notice notice);

    /**
     * id查询数据
     *
     * @param id id
     * @return Notice
     */
    Notice findById(Long id);

    Notice queryByNewTime();

    PageInfo<Notice> findAll(int page, int pageSize, String title);
}

