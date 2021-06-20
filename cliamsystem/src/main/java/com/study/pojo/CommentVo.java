package com.study.pojo;


import java.util.List;

public class CommentVo  extends  Comment{
    //添加个用户的照片 用来前端显示
    private String uphoto;

    //添加评论list
    private List<CommentVo> list;

    public void setList(List<CommentVo> lists) {
        this.list = lists;
    }

    public List<CommentVo> getList() {
        return list;
    }

    public String getUphoto() {
        return uphoto;
    }

    public void setUphoto(String uphoto) {
        this.uphoto = uphoto;
    }
}
