package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_offer_details")
@ApiModel(value = "OfferDetails对象", description = "")
public class OfferDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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

    @ApiModelProperty("备注")
    @TableField("remake")
    private Long remake;

    @ApiModelProperty("虚拟删除(0是未删，1是删除)")
    @TableField("is_delete")
    private Integer isDelete;


}
