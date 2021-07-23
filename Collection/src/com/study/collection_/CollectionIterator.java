package com.study.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//Iterator使用
public class CollectionIterator {

    public static void main(String[] args) {

        Collection col = new ArrayList();

        col.add(new Book("三国演义","罗贯中",10.1));
        col.add(new Book("小李飞刀","古龙",5.1));
        col.add(new Book("红楼梦","曹雪芹",34.6));

        System.out.println("直接打印");
        System.out.println("col=" + col);

        System.out.println("迭代器打印");
        //1.先得到col对应的迭代器
        Iterator it = col.iterator();
        //2.使用while循环遍历
//        while (it.hasNext()){
//            Object obj = it.next();
//            System.out.println("obj=" + obj);
//        }

        //快捷键生成迭代器 itit
        //ctrl + j 显示快捷模板
        while (it.hasNext()) {
            Object next =  it.next();
            System.out.println("next=" + next);
        }
        //3.当退出while循环后，这时迭代器指向最后的元素
        //System.out.println(it.next());//NoSuchElementException
        //如果需要再次遍历,需要重置迭代器
        System.out.println();
        it = col.iterator();
        while (it.hasNext()) {
            Object next =  it.next();
            System.out.println("next=" + next);
        }


    }

}

class Book{
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
