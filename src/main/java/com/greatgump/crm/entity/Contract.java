package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 合同管理
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_contract")
@ApiModel(value = "Contract对象", description = "合同管理")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("合同编号")
    @TableField("contract_num")
    private String contractNum;

    @ApiModelProperty("签订日期")
    @TableField("signing_date")
    private Date signingDate;

    @ApiModelProperty("合同名称")
    @TableField("contract_name")
    private String contractName;

    @ApiModelProperty("客户名称")
    @TableField("customer_name")
    private String customerName;

    @ApiModelProperty("我方签订人")
    @TableField("our_signatory")
    private String ourSignatory;

    @ApiModelProperty("对方签订人")
    @TableField("your_signatory")
    private String yourSignatory;

    @ApiModelProperty("合同金额")
    @TableField("contract_amount")
    private String contractAmount;

    @ApiModelProperty("业务员")
    @TableField("saler")
    private String saler;

    @ApiModelProperty("对方公司联系人")
    @TableField("contacts")
    private String contacts;

    @ApiModelProperty("上传合同")
    @TableField("contrac_url")
    private String contracUrl;

    @ApiModelProperty("对方公司联系人电话")
    @TableField("contacts_phone")
    private String contactsPhone;

    @ApiModelProperty("付款方式")
    @TableField("pay_method")
    private String payMethod;

    @ApiModelProperty("付款日期")
    @TableField("pay_date")
    private Date payDate;

    @ApiModelProperty("备注")
    @TableField("remake")
    private String remake;

    @ApiModelProperty("虚拟删除(0是未删，1是删除)")
    @TableField("is_delete")
    private Integer isDelete;


}
