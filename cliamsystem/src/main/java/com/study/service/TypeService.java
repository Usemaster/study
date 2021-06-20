package com.study.service;

import com.github.pagehelper.PageInfo;
import com.study.pojo.Type;
import com.study.pojo.User;
import com.study.vo.TypeVo;

import java.util.List;

public interface TypeService {
    /**
     * 分页查询
    */
    PageInfo<Type> findAll(int page, int pageSize, String typeName);

    /**
     * 添加
      */

    int insertType(Type type);

    /**
     * 删除 根据id删除 Integer类型可以为null而int类型不能
    */
    int deleteTypeByID(Integer id);

    /**
     * 根据类型统计数量
     */
    List<TypeVo> getCountsByType();

}
