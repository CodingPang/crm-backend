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
public class CostDto {
    @ApiModelProperty("费用标题")
    private  String costName;

    @ApiModelProperty("费用类型")
    private Integer costType;

    @ApiModelProperty("关联客户")
    private String customer;

    @ApiModelProperty("负责人员")
    private String username;

    @ApiModelProperty("关联订单")
    private String order;

    @ApiModelProperty("关联商机")
    private String business;
    @ApiModelProperty("费用金额")
    private Long costMoney;

    @ApiModelProperty("发生时间")
    private String happenedTime;

    @ApiModelProperty("费用描述")
    private String remark;

    @ApiModelProperty("录入人员")
    private String inputName;

    @ApiModelProperty("创建时间")
    private Date createTime;

}
