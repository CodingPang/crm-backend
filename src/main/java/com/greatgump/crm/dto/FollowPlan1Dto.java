package com.greatgump.crm.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;

@Data
public class FollowPlan1Dto {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("开始时间")
    private Date startTime;

    @ApiModelProperty("计划标题")
    private String title;

    @ApiModelProperty("负责人")
    private String username ;

    @ApiModelProperty("计划进度")
    private String planProgress;

    @ApiModelProperty("重要程度")
    private String planDegree;
}
