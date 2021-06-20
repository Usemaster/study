package com.study.controller;

import com.study.jwt.JWTUtil;
import com.study.pojo.User;
import com.study.service.IUserService;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Resource
    private IUserService userService;

    @RequestMapping("/loginIn")
    public Map loginIn(@RequestBody Map<String,String> map){
        Map m = new HashMap();
        String username = map.get("username");
        String pwd = map.get("password");
        pwd= DigestUtils.md5DigestAsHex(pwd.getBytes());
        //根据接收到的用户名密码是否存在
        User user = userService.queryUserByNameAndPwd(username, pwd);
        if (user!=null){
            //生成token
            String token = JWTUtil.createJsonWebToken(user);
            m.put("code",200);
            m.put("token",token);
            m.put("username",user.getUsername());
            m.put("type",user.getType());
            return m;
        }else{
            m.put("msg","用户名或密码错误");
        }
        return m;
    }

}
