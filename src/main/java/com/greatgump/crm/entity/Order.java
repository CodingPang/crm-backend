package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
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
@TableName("t_order")
@ApiModel(value = "Order对象", description = "")
public class Order implements Serializable {

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
    private Customer customer;

    @ApiModelProperty("订单归属(外键，销售id)")
    @TableField("sale_id")
    private User sale;

    @ApiModelProperty("关联商机(外键，商机id)")
    @TableField("business_id")
    private Business business;

    @ApiModelProperty("关联产品表(外键，产品id)")
    @TableField("product_id")
//    private List<Product> product;
    private Product product;

    @ApiModelProperty("订单总额")
    @TableField("oder_total")
    private BigDecimal oderTotal;

    @ApiModelProperty("审批状态(0代表是已驳回，1代表已通过，2代表待审批)")
    @TableField("oder_status")
    private String oderStatus;

    @ApiModelProperty("上传附件(外键，附件表id)")
    @TableField("upload_attachment_id")
    private UploadAttachment uploadAttachment;

    @ApiModelProperty("付款方式(0表示现金支付，1表示对公转账)")
    @TableField("pay_methods")
    private Integer payMethods;

    @ApiModelProperty("订单合同(外键，合同表)")
    @TableField("order_contract")
    private Contract orderContract;

    @ApiModelProperty("我方签订人(user表id)")
    @TableField("owner_signer")
    private User ownerSigner;

    @ApiModelProperty("我方联系人联系方式(user_phone)")
    @TableField("owner_signer_phone")
    private String ownerSignerPhone;

    @ApiModelProperty("对面签订人(联系人id)")
    @TableField("face_signer")
    private Contact faceSigner;

    @ApiModelProperty("对方联系人联系方式(contact_hone)")
    @TableField("face_signer_phone")
    private String faceSignerPhone;

    @ApiModelProperty("签单日期")
    @TableField("order_date")
    private String orderDate;

    @ApiModelProperty("已回款金额")
    @TableField("total_res")
    private BigDecimal totalRes;

    @ApiModelProperty("已开票金额")
    @TableField("total_ticket")
    private BigDecimal totalTicket;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("虚拟删除(0是未删，1是删除)")
    @TableField("is_delete")
    @TableLogic
    private Integer isDelete;

}
