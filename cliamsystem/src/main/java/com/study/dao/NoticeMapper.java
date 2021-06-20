package com.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.pojo.Notice;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kappy
 * @since 2021-06-14
 */
@Component("noticeDao")
public interface NoticeMapper extends BaseMapper<Notice> {

    Notice queryByNewTime();

}
