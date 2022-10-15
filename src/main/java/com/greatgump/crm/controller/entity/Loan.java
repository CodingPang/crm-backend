package com.greatgump.crm.controller.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
* <p>
  * 借款表
  * </p>
* @author team6
* @since 2022-10-15 04:12:20
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
      @Accessors(chain = true)
  @TableName("t_loan")
  @ApiModel(value = "Loan对象", description = "借款表")
  public class Loan implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("主键，自增")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("关联业务(外键，关联客户)")
      @TableField("associated_business")
  private String associatedBusiness;

          @ApiModelProperty("借款金额")
      @TableField("loan_amount")
  private BigDecimal loanAmount;

          @ApiModelProperty("借款原因")
      @TableField("cause")
  private String cause;

          @ApiModelProperty("审批状态（1表示已通过，2表示待审批，0表示已驳回）")
      @TableField("approval_status")
  private Integer approvalStatus;

          @ApiModelProperty("申请时间")
      @TableField("appplication_time")
      @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date appplicationTime;

          @ApiModelProperty("申请人员")
      @TableField("applicant")
  private String applicant;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("假删")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
