package com.study.dao;

import com.study.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodMapper {
    //增加一个Book
    int addGood(Goods book);

    //根据id删除一个Book
    int deleteGoodById(@Param("bookID") int id);

    //更新Book
    int updateGood(Goods goods);

    //根据id查询,返回一个Book
    Goods queryGoodById(@Param("bookID") int id);

    //查询全部Book,返回list集合
    List<Goods> queryAllGood();

    Goods queryGoodByName(@Param("bookName") String bookName);
}
