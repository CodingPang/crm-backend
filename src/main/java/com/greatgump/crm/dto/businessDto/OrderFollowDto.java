package com.greatgump.crm.dto.businessDto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderFollowDto {
    @ApiModelProperty("关联客户")
    @TableField("customer")
    private String customer;

    @ApiModelProperty("联系人员")
    @TableField("person")
    private String person;


    @ApiModelProperty("跟进时间")
    @TableField("followdate")
    private String followdate;

    @ApiModelProperty("跟进人员")
    @TableField("follow_people")
    private String followPeople;

    @ApiModelProperty("跟进方式")
    @TableField("follow_method")
    private String followMethod;

    @ApiModelProperty("跟进内容")
    @TableField("follow_context")
    private String followContext;
}
