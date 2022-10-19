package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@TableName("t_offer_details")
@ApiModel(value = "offerdto对象", description = "商机管理")
public class OfferDetailsDto {

    @ApiModelProperty("产品名称")
    @TableField("product")
    private String product;

    @ApiModelProperty("产品编号")
    @TableField("product_id")
    private String productId;

    @ApiModelProperty("产品规格")
    @TableField("product_size")
    private String productSize;

    @ApiModelProperty("产品单价")
    @TableField("price")
    private Double price;

    @ApiModelProperty("产品数量")
    @TableField("number")
    private Integer number;

    @ApiModelProperty("折扣率")
    @TableField("discount")
    private String discount;

    @ApiModelProperty("产品报价")
    @TableField("real_price")
    private Double realPrice;

    @ApiModelProperty("公司")
    @TableField("company")
    private Long company;

    private Long remark;
}
