package com.usemaster.dubbo.web;

import com.usemaster.dubbo.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gongwj
 * @Date 2022/6/4
 */
@Controller
public class SomeController {

    @Autowired
    private SomeService someService;

    @RequestMapping(value = "/hello")
    public String hello(Model model){
        //调用远程接口服务
        String hello = someService.hello("World");



        model.addAttribute("hello",hello);

        return "hello";
    }

}
