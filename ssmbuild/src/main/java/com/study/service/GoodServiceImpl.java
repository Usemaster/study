package com.study.service;

import com.study.dao.GoodMapper;
import com.study.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    //service调dao层：组合dao
    //调用dao层的操作，设置一个set接口，方便Spring管理
    @Autowired
    private GoodMapper goodMapper;

    public void setBookMapper(GoodMapper goodMapper) {
        this.goodMapper = goodMapper;
    }

    public int addGood(Goods book) {
        return goodMapper.addGood(book);
    }

    public int deleteGoodById(int id) {
        return goodMapper.deleteGoodById(id);
    }

    public int updateGood(Goods goods) {
        return goodMapper.updateGood(goods);
    }

    public Goods queryGoodById(int id) {
        return goodMapper.queryGoodById(id);
    }

    public List<Goods> queryAllGood() {
        return goodMapper.queryAllGood();
    }

    public Goods queryGoodByName(String bookName) {
        return goodMapper.queryGoodByName(bookName);
    }
}
