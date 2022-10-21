package com.greatgump.crm.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderBusinessDto {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("订单标题")
    private String orderTitle;
    @ApiModelProperty("审批状态")
    private String orderStatus;
    @ApiModelProperty("订单总额")
    private String orderTotal;
    @ApiModelProperty("已回款金额")
    private String totalRes;
    @ApiModelProperty("已开票金额")
    private String totalTicket;
}
