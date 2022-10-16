package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

public class OfferDto {

    @ApiModelProperty("单号")
    @TableField("odd_num")
    private String oddNum;

    @ApiModelProperty("创建时间")
    @TableField("creation_date")
    private Date creationDate;

    @ApiModelProperty("客户")
    @TableField("customer_id")
    private String customerId;

    @ApiModelProperty("报价人")
    @TableField("saler_id")
    private String salerId;

    @ApiModelProperty("联系人")
    @TableField("contacts_id")
    private String contactsId;

    @ApiModelProperty("售价总额")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("折扣率")
    @TableField("discount_tate")
    private String discountTate;

    @ApiModelProperty("报价总额")
    @TableField("offer")
    private BigDecimal offer;

    @ApiModelProperty("备注")
    @TableField("remake")
    private String remake;

    @ApiModelProperty("虚拟删除(0表示未删除，1表示删除)")
    @TableField("is_delete")
    private Integer isDelete;
    private Long id;
    private String product_name;
    private String product_code;
    private String unit;
    private Double totalprice;
}
