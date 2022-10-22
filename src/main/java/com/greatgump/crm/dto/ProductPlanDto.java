package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.greatgump.crm.entity.Assort;
import com.greatgump.crm.entity.CalcUnit;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProductPlanDto {
    @ApiModelProperty("id")
    @TableField("id")
    private int id;

    @ApiModelProperty("产品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty("产品编码")
    @TableField("product_code")
    private String productCode;

    @ApiModelProperty("计量单位")
    @TableField("unitid")
    private Integer unitid;

    @ApiModelProperty("销售单价")
    @TableField("price")
    private Integer price;

    @ApiModelProperty("折扣率")
    private String rate;

    @ApiModelProperty("产品报价")
    @TableField("b_offer")
    private String bOffer;


}
