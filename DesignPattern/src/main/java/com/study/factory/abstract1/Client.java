package com.study.factory.abstract1;

public class Client {

    public static void main(String[] args) {
        System.out.println("===========小米系列产品===========");
        //小米工厂
        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        //小米手机
        IphoneProduct iphoneProduct = xiaomiFactory.iphoneProduct();
        iphoneProduct.callup();
        iphoneProduct.sendSMS();
        //小米路由器
        IRouterProduct iRouterProduct = xiaomiFactory.routerProduct();
        iRouterProduct.openWifi();
        iRouterProduct.setting();
        System.out.println("===========华为系列产品===========");
        //华为工厂
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        //华为手机
        iphoneProduct = huaweiFactory.iphoneProduct();
        iphoneProduct.callup();
        iphoneProduct.sendSMS();
        //华为路由器
        iRouterProduct = huaweiFactory.routerProduct();
        iRouterProduct.openWifi();
        iRouterProduct.setting();

    }

}
