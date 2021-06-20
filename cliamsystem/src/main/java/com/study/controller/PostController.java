package com.study.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.study.jwt.JWTUtil;
import com.study.pojo.Notice;
import com.study.pojo.Post;
import com.study.pojo.User;
import com.study.service.*;
import com.study.util.JsonObject;
import com.study.util.R;
import com.study.vo.TypeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.channels.MulticastChannel;
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
@RequestMapping("/post")
public class PostController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IPostService postService;

    //引入评论
    @Resource
    private ICommentService commentService;

    @Autowired
    private TypeService typeService;

    @Resource
    private INoticeService noticeService;

    @Resource
    private IUserService userService;

    /**
     * 高级查询分页处理
     */
    @RequestMapping("/queryAll")
    public JsonObject queryAll(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "15")Integer limit,
                               Post post){
        //查询类型列表信息
        PageInfo<Post> pageInfo = postService.findAll(page, limit, post);
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
            postService.delete(new Long(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Post post){
        int num = postService.updateData(post);
        if (num>0){
           return R.ok();
        }
        return R.fail("修改失败");
    }


    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Post> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return postService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Post findById(@PathVariable Long id){
        return postService.findById(id);
    }

    /**
    * 主要用来前端主页的渲染工作
     */
    @RequestMapping("/queryIndexList")
    public Map queryIndexList(@RequestBody Map<String,String> map){
        Post post = new Post();
        //接收高级查询带来的参数信息
        if (map.containsKey("status")){
            String status = map.get("status");
            post.setStatus(Integer.parseInt(status));
        }

        if (map.containsKey("flag")){
            String flag = map.get("flag");
            post.setFlag(Integer.parseInt(flag));
        }

        if (map.containsKey("typeName")){
            String typeName = map.get("typeName");
            post.setTypeName(typeName);
        }

        if(map.containsKey("title")){
            String title= map.get("title");
            post.setTitle(title);
        }

        //创建map对象用来返回前端
        Map m = new HashMap();
        /**
            1.查询post列表信息（支持高级查询）
                1.1支持高级查询(标签、分类、标题)
                1.2查询过程中需要统计每条记录的统计数（根据id查询反馈信息）
            2.查询分类信息，并统计分类相关的post信息
            3.查询公告信息
            4.根据标签（状态）统计数据量
         */

        //查询post列表
        PageInfo<Post> pageInfo = postService.findAll(1,100,post);
        List<Post> list = pageInfo.getList();
        //遍历列表 放入每个信息的评论数量
        for (Post p : list) {
            Long id = p.getId();
            //获取当前id的评论数
            int nums = commentService.getCommentCounts(id);
            p.setCounts(nums);
        }

        m.put("list", list);

        //查询分类信息，并统计分类相关的post信息
        List<TypeVo> type = typeService.getCountsByType();
        m.put("typeList",type);
        //根据状态查询具体的信息数量
        //失物招领 完成 1 0
        int swzl = postService.getCountsByFlagAndStatus(1,0);
        //失物招领 未完成 1 1
        int wswzl = postService.getCountsByFlagAndStatus(1,1);
        //寻物启事 完成 0 0
        int xwqs = postService.getCountsByFlagAndStatus(0,0);
        //寻物启事 未完成 0 1
        int wxwqs = postService.getCountsByFlagAndStatus(0,1);
        m.put("swzl",swzl);
        m.put("wswzl",wswzl);
        m.put("xwqs",xwqs);
        m.put("wxwqs",wxwqs);
        //查询公告最新信息
        Notice notice = noticeService.queryByNewTime();
        m.put("notice",notice);

        return m;
    }

    @RequestMapping("/queryCommentList")
    public Post queryCommentList(@RequestBody Map<String,String> map){
        //接收前端传来的id信息
        String postId = map.get("postId");
        /*
        * 1.根据id查询post详细信息
        * 2.查询当前发布者用户信息
        * 3.查询当前寻物启事的评论信息
        * */
        //根据id查询的post对象
        Post post = postService.findById(new Long(postId));
        //获取评论数信息
        int counts = commentService.getCommentCounts(new Long(postId));
        post.setCounts(counts);
        //修改浏览次数
        Integer count = post.getViewCount();
        Post p = new Post();
        p.setId(new Long(postId));
        p.setViewCount(count+1);

        //修改次数
        postService.updateData(p);
        return post;
    }

    /**
    * 发布启事
     */
    @RequestMapping("/add")
    public R addPost(@RequestPart("post") Post post,
                     HttpServletRequest request,
                     @RequestParam("upload")MultipartFile upload) throws IOException {
        //设置路径
        String path="d://images/";
        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        String token=request.getHeader("token");
        String username= JWTUtil.getUserName(token);
        String filename=upload.getOriginalFilename();
        filename= UUID.randomUUID().toString().replace("-","")+"_"+filename;
        upload.transferTo(new File(path,filename));
        post.setPicture("/images/"+filename);
        post.setCtime(new Date());
        post.setStatus(1);
        post.setUname(username);
        post.setViewCount(0);
        int num=postService.add(post);
        if(num>0){
            return R.ok();
        }
        return R.fail("发布失败");
    }
    /**
     * 主要用来渲染我的主页的数据
     */
    @RequestMapping("/queryMyList")
    public Map queryMyList(HttpServletRequest request){
        Post post=new Post();
        //创建map对象用来返回前端
        Map  m=new HashMap();
         /*
             1、查询用户相关启示信息（根据用户名） 登录信息  假设
          */
//        String uname="kappy";//假设数据
//        long uid=22;
        //通过token获取用名称
        String token=request.getHeader("token");
        String username= JWTUtil.getUserName(token);
        long uid=JWTUtil.getUserId(token);
        post.setUname(username);
        //查询post列表信息
        PageInfo<Post> pageInfo=postService.findAll(1,100,post);
        List<Post> list=pageInfo.getList();
        //遍历列表 放入每个信息的评论数量
        for(Post p:list){
            Long id=p.getId();
            //获取当前id的评论数
            int nums= commentService.getCommentCounts(id);
            p.setCounts(nums);
        }

        m.put("list",list);
        //查询个人的详细信息
        User user=userService.findById(uid);
        m.put("user",user);
        return m;
    }

    /**
     * 修改状态信息 1为进行中，0为结束
     */
    @RequestMapping("/updateStatus")
    public R updateStatus(@RequestBody Map<String,String> map){
        //获取postId
        String postId=map.get("id");
        String status=map.get("status");
        Post post=new Post();
        post.setId(Long.parseLong(postId));
        post.setStatus(Integer.parseInt(status));
        int num=postService.updateData(post);
        if(num>0){
            return R.ok();
        }
        return R.fail("修改状态失败");
    }

    /**
     * 删除个人发布信息
     */
    @RequestMapping("/deletePostById")
    public R deletePostById(@RequestBody Map<String,String> map){
        //获取postId
        String postId=map.get("id");
        int num=postService.delete(new Long(postId));
        if(num>0){
            return R.ok();
        }
        return R.fail("删除失败");
    }


}
