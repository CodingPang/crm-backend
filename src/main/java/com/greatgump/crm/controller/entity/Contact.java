package com.greatgump.crm.controller.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
* <p>
  * 企业联系人表
  * </p>
* @author team6
* @since 2022-10-15 04:12:19
*/
  @NoArgsConstructor
  @AllArgsConstructor
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
  private Integer isDefault;

          @ApiModelProperty("顾客的id")
      @TableField("customer_id")
  private Long customerId;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("删除（0未删，1删除）")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
