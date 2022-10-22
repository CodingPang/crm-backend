package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChasingAddDto {
    @ApiModelProperty("关联客户")
    @TableField("customer")
    private String customer;

    @ApiModelProperty("联系人")
    @TableField("concat")
    private String concat;

    @ApiModelProperty("跟进时间")
    @TableField("progressive_time")
    private String progressiveTime;

    @ApiModelProperty("跟进人员")
    @TableField("userName")
    private String userName;

    @ApiModelProperty("跟进方式")
    @TableField("chasing_method")
    private String chasingMethod;


    @ApiModelProperty("跟进内容")
    @TableField("catch_content")
    private String catchContent;
}
