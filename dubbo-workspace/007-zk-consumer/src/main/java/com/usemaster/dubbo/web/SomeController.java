package com.usemaster.dubbo.web;

import com.usemaster.dubbo.model.User;
import com.usemaster.dubbo.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gongwj
 * @Date 2022/6/8
 */
@Controller
public class SomeController {

    @Autowired
    private SomeService someService;

    @RequestMapping(value = "/hello")
    public String hello(Model model){
        //调用远程接口服务
        String hello = someService.hello();
        model.addAttribute("hello",hello);
        return "hello";
    }

    @RequestMapping(value = "/user/detail")
    public String userDetail(Model model,Integer id){
        //调用远程接口服务
        User user = someService.queryUserById(id);
        model.addAttribute("user",user);
        return "userDetail";
    }

}
