package com.study.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.study.jwt.JWTUtil;
import com.study.pojo.Feedback;
import com.study.pojo.Post;
import com.study.pojo.Type;
import com.study.service.IFeedbackService;
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
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
@RequestMapping("/feedback")
public class FeedbackController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IFeedbackService feedbackService;

    @RequestMapping("/queryAll")
    public JsonObject queryAll(@RequestParam(defaultValue = "1")Integer page,
                               @RequestParam(defaultValue = "15")Integer pageSize,
                               String title){
        //查询类型列表信息
        PageInfo<Feedback> pageInfo = feedbackService.findAll(page, pageSize, title);
        //创建返回的对象
        JsonObject object = new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());
        return object;
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
            feedbackService.delete(new Long(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Feedback feedback , HttpServletRequest request){
        feedback.setCtime(new Date());
        String token=request.getHeader("token");
        String username= JWTUtil.getUserName(token);
        feedback.setUname(username);
        int num= feedbackService.add(feedback);
        if(num>0){
            return R.ok();
        }
        return R.fail("失败");
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Feedback feedback){
        return feedbackService.updateData(feedback);
    }



    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Feedback findById(@PathVariable Long id){
        return feedbackService.findById(id);
    }

}
