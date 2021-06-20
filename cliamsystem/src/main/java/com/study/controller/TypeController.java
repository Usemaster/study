package com.study.controller;


import com.github.pagehelper.PageInfo;
import com.study.pojo.Type;
import com.study.service.TypeService;
import com.study.util.JsonObject;
import com.study.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;
    /**
    * 查询类型接口
     */
    @RequestMapping("/queryAll")
    public JsonObject queryAll(@RequestParam(defaultValue = "1")Integer page,
                               @RequestParam(defaultValue = "15")Integer pageSize,
                               String typeName){
        //创建返回的对象
        JsonObject object = new JsonObject();
        //查询类型列表信息
        PageInfo<Type> pageInfo = typeService.findAll(page, pageSize, typeName);
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    /**
    * 添加功能
     */
    @RequestMapping("/add")
    public R add(@RequestBody Type type){
        int num = typeService.insertType(type);
        if(num>0){
            return R.ok();
        }
        return R.fail("不好意思，添加失败");
    }

    /**
     * 删除功能(支持批量和单个删除)
      */
    @RequestMapping("/deleteByIds")
    public R deleteByIds(String ids){
        //把接收到的字符串转集合对象
        List<String> list = Arrays.asList(ids.split(","));
        //遍历id删除对象
        for (String id : list) {
            typeService.deleteTypeByID(Integer.parseInt(id));
        }
        return R.ok();
    }

    /**
    * 查询类型列表
     */
    @RequestMapping("/list")
    public List<Type> queryTypeList(){
        PageInfo<Type> pageInfo = typeService.findAll(1, 20, null);
        return  pageInfo.getList();
    }

}
