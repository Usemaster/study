package com.study.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author kappy
 * @since 2021-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Comment对象", description="")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "贴子ID")
    private Long postId;

    @ApiModelProperty(value = "评论人")
    private String uname;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "评论时间")
    private Date ctime;

    @ApiModelProperty(value = "是否有父评论")
    private Long parent;

//    //添加评论list
//    private List<Comment> list;

}
