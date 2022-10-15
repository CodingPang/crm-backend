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
  * 
  * </p>
* @author team6
* @since 2022-10-15 04:12:20
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
      @Accessors(chain = true)
  @TableName("t_refund")
  @ApiModel(value = "Refund对象", description = "")
  public class Refund implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("主键，自增")
          @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

          @ApiModelProperty("退款单号")
      @TableField("refund_number")
  private String refundNumber;

          @ApiModelProperty("关联订单")
      @TableField("associated_order")
  private String associatedOrder;

          @ApiModelProperty("关联客户")
      @TableField("customer_name")
  private String customerName;

          @ApiModelProperty("退款金额")
      @TableField("refund_amount")
  private BigDecimal refundAmount;

          @ApiModelProperty("审批状态(1代表已通过，2代表待审批，0代表已驳回)")
      @TableField("approval_status")
  private String approvalStatus;

          @ApiModelProperty("提交人员")
      @TableField("submitter")
  private String submitter;

          @ApiModelProperty("提交时间")
      @TableField("submission_time")
      @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date submissionTime;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("假删")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
