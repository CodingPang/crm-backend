package com.greatgump.crm.dto.productlibrary;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
public class ProductSearch {
    @ApiModelProperty("产品名称")
    private String productName;
    @ApiModelProperty("开始时间")
    private String startTime;
    @ApiModelProperty("结束时间")
    private String endTime;
    @ApiModelProperty(value = "当前多少页--必填",required = true)
    private Integer current;
    @ApiModelProperty(value = "每页多少条记录--必填",required = true)
    private Integer size;
}
