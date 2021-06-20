package com.study.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.study.pojo.Notice;
import com.study.service.INoticeService;
import com.study.util.JsonObject;
import com.study.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kappy
 * @since 2021-01-07
 */
@Api(tags = {""})
@RestController
@RequestMapping("/notice")
public class NoticeController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private INoticeService noticeService;

    @RequestMapping("/queryAll")
    public JsonObject queryAll(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "15") Integer limit,
                               String title){
        JsonObject object=new JsonObject();
        PageInfo<Notice> pageInfo= noticeService.findAll(page,limit,title);
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Notice notice){
        notice.setCtime(new Date());
//        notice.setCuser("");//
        int num=noticeService.add(notice);
        if(num>0){
            return R.ok();
        }
        return R.fail("失败");
    }

    /**
     * 删除功能(支持批量和单个删除)
     */
    @RequestMapping(value = "/deleteByIds")
    public R deleteByIds(String ids){
        //把接收到的字符串转集合对象
        List<String> list= Arrays.asList(ids.split(","));
        //遍历id删除对象
        for(String id:list){
            noticeService.delete(new Long(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Notice notice){
        return noticeService.updateData(notice);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Notice> findListByPage(@RequestParam Integer page,
                                        @RequestParam Integer pageCount){
        return noticeService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Notice findById(@PathVariable Long id){
        return noticeService.findById(id);
    }

}
