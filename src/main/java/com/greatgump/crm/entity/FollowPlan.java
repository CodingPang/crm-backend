package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

@Data
@Api(tags = "t_follow_plan")
public class FollowPlan {
    @ApiModelProperty("id")
    @TableField("id")
    private Integer id;

    @ApiModelProperty("客户id")
    @TableField("customer_id")
    private Integer customerId;

    @ApiModelProperty("开始时间")
    @TableField("begin_time")
    private Date beginTime;

    @ApiModelProperty("计划标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("负责人")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("计划进度")
    @TableField("plan_progress")
    private String planProgress;

    @ApiModelProperty("重要程度")
    @TableField("plan_degree")
    private String  planDegree;


}
