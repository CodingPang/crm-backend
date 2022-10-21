package com.greatgump.crm.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProductCountDto {
    @ApiModelProperty("报价记录")
    private Integer countNotes;
    @ApiModelProperty("产品数量")
    private Integer countNumber;
    @ApiModelProperty("售价总额")
    private String allPrice;
    @ApiModelProperty("折扣率")
    private String rates;
    @ApiModelProperty("offPrice")
    private String offPrice;
}
