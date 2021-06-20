package com.study.controller;


import com.github.pagehelper.PageInfo;
import com.study.jwt.JWTUtil;
import com.study.pojo.User;
import com.study.service.IUserService;
import com.study.util.JsonObject;
import com.study.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kappy
 * @since 2021-06-14
 */
@Api(tags = {""})
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserService userService;

    /**
    * 高级查询分页处理
     */
    @RequestMapping("/queryAll")
    public JsonObject queryAll(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "15")Integer limit,
                               User user){
        //查询类型列表信息
        PageInfo<User> pageInfo = userService.findAll(page, limit, user);
        //创建返回的对象
        JsonObject object = new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());
        return object;
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody User user){
        String pwd=user.getPassword();
        //加密
        pwd=DigestUtils.md5DigestAsHex(pwd.getBytes());
        user.setPassword(pwd);
        int num= userService.add(user);
        if(num>0){
            return R.ok();
        }
        return R.fail("用户添加失败");
    }

    /**
     * 删除功能(支持批量和单个删除)
     */
    @RequestMapping("/deleteByIds")
    public R deleteByIds(String ids,HttpServletRequest request){
        String token=request.getHeader("token");
        Long uid= JWTUtil.getUserId(token);
        //把接收到的字符串转集合对象
        List<String> list= Arrays.asList(ids.split(","));
        //遍历id删除对象
        for(String id:list){
            long userId=new Long(id);
            //如果是当前用户，不能删除
            if(userId==uid){//当前用户
                return R.fail(405,"删除失败，不能删除自己");
            }
            userService.delete(new Long(id));
        }
        return R.ok();
    }

    /**
     * 修改密码
     */
    @RequestMapping("/update")
    public R update(@RequestBody Map<String,String> map){
        //获取信息
        String id = map.get("id");
        String oldpwd = map.get("oldpwd");
        String newpwd = map.get("newpwd");
        //根据id判断当前对象是否存在
        User user = userService.findById(new Long(id));
        if (user.getPassword().equals(oldpwd)){
            //重新设置密码
            User u = new User();
            u.setId(new Long(id));
            u.setPassword(newpwd);
            userService.updateData(u);
            return R.ok();
        }else{
            return R.fail("输入原密码不正确...");
        }

    }

    /**
     * 编辑个人信息
     */
    @RequestMapping("/edit")
    public R editUser(@RequestPart("user") User user ,
//                      @RequestParam("upload") MultipartFile upload,
//                      @RequestParam(name = "upload2") MultipartFile upload2,
                      HttpServletRequest request) throws IOException {
        //个人信息的id 后续通过token对象获取
//        long uid=22;//设置
        String token=request.getHeader("token");
        Long uid= JWTUtil.getUserId(token);
        //设置路径
        String path="d://images/";
        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        user.setId(uid);
//        if(upload!=null){
//            //个人头像
//            String filename=upload.getOriginalFilename();
//            filename= UUID.randomUUID().toString().replace("-","")+"_"+filename;
//            upload.transferTo(new File(path,filename));
//            user.setPhoto("/images/"+filename);
//        }
//        if(upload2!=null){
//            //打赏码
//            String erwei=upload2.getOriginalFilename();
//            erwei= UUID.randomUUID().toString().replace("-","")+"_"+erwei;
//            upload2.transferTo(new File(path,erwei));
//            user.setRewardCode("/images/"+erwei);
//        }

        //方式2 解决不能不上传情况
        MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
        MultipartFile multipartFile = null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart){
//            MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
            multipartFile = multipartRequest.getFile("upload2");
            if(multipartFile!=null){
                String erwei=multipartFile.getOriginalFilename();
                erwei= UUID.randomUUID().toString().replace("-","")+"_"+erwei;
                multipartFile.transferTo(new File(path,erwei));
                user.setRewardCode("/images/"+erwei);
            }
        }

        MultipartFile multipartFile2 = null;
        boolean isMultipart2 = ServletFileUpload.isMultipartContent(request);
        if (isMultipart2){
            multipartFile2 = multipartRequest.getFile("upload");
            if(multipartFile2!=null){
                String filename=multipartFile2.getOriginalFilename();
                filename= UUID.randomUUID().toString().replace("-","")+"_"+filename;
                multipartFile2.transferTo(new File(path,filename));
                user.setPhoto("/images/"+filename);
            }
        }

        int num=userService.updateData(user);
        if(num>0){
            return R.ok();
        }
        return R.fail("编辑个人信息失败");
    }

    /**
     * 用户注册
    */
    @RequestMapping("/reg")
    public Map regUser(@RequestBody Map<String,String> maps){
        Map m=new HashMap();
        //获取用户名 密码
        String username=maps.get("username");
        //判断该用户名是否已经使用
        User users=userService.queryUserByName(username);
        if(users!=null){
            m.put("msg","用户名已经被使用，请重新注册");
            return m;
        }else{
            String pwd=maps.get("password");
            pwd=DigestUtils.md5DigestAsHex(pwd.getBytes());
            //设置包装对象
            User user=new User();
            user.setUsername(username);
            user.setPassword(pwd);
            user.setType(0);
            int num=userService.add(user);
            if(num>0){
                m.put("msg","注册成功，请登录");
                m.put("code",200);
                return m;
            }else{
                m.put("msg","注册失败，请重新注册");
                return m;
            }

        }
    }

    /**
     * 修改密码
     */
    @RequestMapping("/updatePassword")
    public Map updatePassword(@RequestBody Map<String,String> maps, HttpServletRequest request){
        Map m=new HashMap();
        //获取老密码
        String oldpwd=maps.get("oldpwd");
        oldpwd = DigestUtils.md5DigestAsHex(oldpwd.getBytes());
        //判断该用户名是否已经使用
        //通过token获取用名称
        String token=request.getHeader("token");
        String username= JWTUtil.getUserName(token);
        User users=userService.queryUserByName(username);
        if(!users.getPassword().equals(oldpwd)){
            m.put("msg","输入的原密码不正确,可以重更新修改");
            return m;
        }else {
            String pwd = maps.get("newpwd");
            pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
            //设置包装对象
            User user = new User();
            user.setPassword(pwd);
            user.setId(users.getId());
            int num = userService.updateData(user);
            if (num > 0) {
                m.put("msg", "修改成功，重新登录");
                m.put("code", 200);
                return m;
            } else {
                m.put("msg", "修改失败，请重新修改");
                return m;
            }
        }

    }

}
