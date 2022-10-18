package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
@TableName("t_offer")
@ApiModel(value = "Offer对象", description = "")
public class Offer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("单号")
    @TableField("odd_num")
    private String oddNum;

    @ApiModelProperty("创建时间")
    @TableField("creation_date")
    private Date creationDate;

    @ApiModelProperty("客户")
    @TableField("customer")
    private String customer;

    @ApiModelProperty("报价人")
    @TableField("saler")
    private String saler;

    @ApiModelProperty("联系人")
    @TableField("contacts")
    private String contacts;

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


}
