package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
@TableName("t_order")
@ApiModel(value = "Order对象", description = "")
public class Order11 implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增主建")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单编号")
    @TableField("order_no")
    private String orderNo;

    @ApiModelProperty("订单标题")
    @TableField("order_title")
    private String orderTitle;

    @ApiModelProperty("关联客户(外键，客户表id)")
    @TableField("customer_id")
    private Long customerId;

    @ApiModelProperty("订单归属(销售id)")
    @TableField("sale_id")
    private Long saleId;

    @ApiModelProperty("关联商机(商机id)")
    @TableField("business_id")
    private Long businessId;

    @ApiModelProperty("订单总额")
    @TableField("oder_total")
    private BigDecimal oderTotal;


    @ApiModelProperty("上传附件(外键，附件表id)")
    @TableField("upload_attachment_id")
    private Long uploadAttachment;


    @ApiModelProperty("付款方式(0表示现金支付，1表示对公转账)")
    @TableField("pay_methods")
    private Integer payMethods;


    @ApiModelProperty("我方签订人(user表id)")
    @TableField("owner_signer")
    private Long ownerSigner;

    @ApiModelProperty("对面签订人")
    @TableField("face_signer")
    private String faceSigner;

    @ApiModelProperty("对方联系人联系方式(contact_hone)")
    @TableField("face_signer_phone")
    private String faceSignerPhone;

    @ApiModelProperty("签单日期")
    @TableField("order_date")
    private String orderDate;


    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;


}
