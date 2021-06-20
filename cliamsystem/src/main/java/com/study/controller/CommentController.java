package com.study.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.study.jwt.JWTUtil;
import com.study.pojo.Comment;
import com.study.service.ICommentService;
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
import java.util.Date;

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
@RequestMapping("/comment")
public class CommentController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICommentService commentService;


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Comment comment, HttpServletRequest request){
        comment.setCtime(new Date());
        String token=request.getHeader("token");
        String username= JWTUtil.getUserName(token);
        comment.setUname(username);
        int num=commentService.add(comment);
        if(num>0){
            return R.ok();
        }
        return R.fail("发布失败");
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return commentService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Comment comment){
        return commentService.updateData(comment);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Comment> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return commentService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Comment findById(@PathVariable Long id){
        return commentService.findById(id);
    }

}
