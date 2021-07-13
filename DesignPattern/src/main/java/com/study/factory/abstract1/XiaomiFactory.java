package com.study.factory.abstract1;

public class XiaomiFactory implements IProductFactory{
    @Override
    public IphoneProduct iphoneProduct() {
        return new XiaomiPhone();
    }

    @Override
    public IRouterProduct routerProduct() {
        return new XiaomiRouter();
    }
}
