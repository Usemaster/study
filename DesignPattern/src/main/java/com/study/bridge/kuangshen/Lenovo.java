package com.study.bridge.kuangshen;

import com.study.bridge.kuangshen.Brand;

//联想品牌
public class Lenovo implements Brand {
    @Override
    public void info() {
        System.out.print("联想");
    }
}
