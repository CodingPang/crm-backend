package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAddDto {
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
    @ApiModelProperty("产品数量")
    @TableField("number")
    private Integer number;
    @ApiModelProperty("折扣率")
    @TableField("discount")
    private String discount;
    @ApiModelProperty("产品报价")
    @TableField("real_price")
    private Double realPrice;
    @ApiModelProperty("备注")
    @TableField("remake")
    private Long remake;
}
