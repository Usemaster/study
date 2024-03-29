package com.study.prototype.demo02;

import java.util.Date;

public class Video implements Cloneable{

    private String name;
    private Date createTime;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();

        //实现深克隆 序列化，反序列化
        Video v = (Video) obj;
        //将这个对象的属性也进行克隆
        v.createTime = (Date) this.createTime.clone();

        return obj;
    }

    public Video() {
    }

    public Video(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
