package com.study.factory.abstract1;

//华为手机
public class HuaweiPhone implements IphoneProduct{
    @Override
    public void start() {
        System.out.println("开启华为手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为手机");
    }

    @Override
    public void callup() {
        System.out.println("用华为手机打电话");
    }

    @Override
    public void sendSMS() {
        System.out.println("用华为手机发短信");
    }
}
