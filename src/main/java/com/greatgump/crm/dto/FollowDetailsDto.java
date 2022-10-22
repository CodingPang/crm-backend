package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
public class FollowDetailsDto {
    @ApiModelProperty("id")
    @TableField("id")
    private Long id;
    @ApiModelProperty("跟进内容")
    @TableField("catch_content")
    private String catchContent;

    @ApiModelProperty("跟进时间")
    @TableField("progressive_time")
    private String progressiveTime;


    @ApiModelProperty("关联客户")
    @TableField("customer_name")
    private String customerName;

    @ApiModelProperty("负责人")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("跟进类型")
    @TableField("follow_type")
    private String followType;

    @ApiModelProperty("跟进方式")
    @TableField("follow_through")
    private String followThrough;

    @ApiModelProperty("联系人员")
    @TableField("contactss")
    private String contactss;


    @ApiModelProperty(" 联系电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("创建时间")
    @TableField("current_time")
    private String createTime;

}
