package com.study.service;

import com.study.pojo.Goods;

import java.util.List;

public interface GoodService {
    //增加一个Book
    int addGood(Goods goods);

    //根据id删除一个Book
    int deleteGoodById(int id);

    //更新Book
    int updateGood(Goods goods);

    //根据id查询,返回一个Book
    Goods queryGoodById(int id);

    //查询全部Book,返回list集合
    List<Goods> queryAllGood();

    Goods queryGoodByName(String goodName);
}
