package com.study.dao;

import com.study.pojo.Type;
import com.study.vo.TypeVo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("typeDao")
public interface TypeMapper {

    /**
    * 查询功能 支持高级查询
     */

    List<Type> queryList(@Param("typeName") String typeName);

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
