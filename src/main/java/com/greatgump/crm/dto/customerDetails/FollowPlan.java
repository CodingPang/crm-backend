package com.greatgump.crm.dto.customerDetails;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class FollowPlan {

    @ApiModelProperty("开始时间")
    private Date beginTime;

    @ApiModelProperty("计划标题")
    private String title;

    @ApiModelProperty("负责人员")
    private String userName;

    @ApiModelProperty("计划进度")
    private String planProgress;

    @ApiModelProperty("重要程度")
    private String planDegree;

}
