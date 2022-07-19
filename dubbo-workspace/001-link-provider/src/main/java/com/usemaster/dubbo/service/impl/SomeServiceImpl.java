package com.usemaster.dubbo.service.impl;

import com.usemaster.dubbo.service.SomeService;

/**
 * @author gongwj
 * @Date 2022/6/4
 */
public class SomeServiceImpl implements SomeService {
    @Override
    public String hello(String msg) {
        return "Hello World" + msg;
    }
}
