package com.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.pojo.Feedback;
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
@Component("feedbackDao")
public interface FeedbackMapper extends BaseMapper<Feedback> {

    //支持标题的模糊查询
    public List<Feedback> queryList(@Param("title") String title);

}
