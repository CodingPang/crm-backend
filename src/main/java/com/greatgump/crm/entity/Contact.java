package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 企业联系人表
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Data
@Accessors(chain = true)
@TableName("t_contact")
@ApiModel(value = "Contact对象", description = "企业联系人表")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("联系人名称")
    @TableField("contact_name")
    private String contactName;

    @ApiModelProperty("邮箱")
    @TableField("mail")
    private String mail;

    @ApiModelProperty("电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("QQ")
    @TableField("qq")
    private String qq;

    @ApiModelProperty("部门")
    @TableField("department")
    private String department;

    @ApiModelProperty("微信")
    @TableField("wechat")
    private String wechat;

    @ApiModelProperty("默认联系方式 (1是，0否)")
    @TableField("is_default")
    @TableLogic
    private Integer isDefault;

    @ApiModelProperty("顾客的id")
    @TableField("customer_id")
    private Long customerId;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("删除（0未删，1删除）")
    @TableField("is_delete")
    private Integer isDelete;


}
