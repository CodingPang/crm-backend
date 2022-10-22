package com.greatgump.crm.dto.productlibrary;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductsearchDto {
    @ApiModelProperty("产品名称")
    private String productName;
    @ApiModelProperty("开始时间")
    private Date start;
    @ApiModelProperty("结束时间")
    private Date end;
    @ApiModelProperty("页数")
    private Long current;
    @ApiModelProperty("条数")
    private Long size;
}
