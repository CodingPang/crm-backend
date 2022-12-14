package com.greatgump.crm.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListDto {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("产品名")
    private String product;
    @ApiModelProperty("产品编号")
    private String productId;
    @ApiModelProperty("计量单位")
    private String productSize;
    @ApiModelProperty("价格")
    private Double price;
    @ApiModelProperty("公司id")
    private Long company;

}
