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
  @TableName("t_write")
  @ApiModel(value = "Write对象", description = "")
  public class Write implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("主键，自增")
          @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

          @ApiModelProperty("报销单号")
      @TableField("odd_numbers")
  private String oddNumbers;

          @ApiModelProperty("报销部门")
      @TableField("department")
  private String department;

          @ApiModelProperty("报销金额")
      @TableField("reimbursement_amount")
  private BigDecimal reimbursementAmount;

          @ApiModelProperty("报销人员")
      @TableField("reimburser")
  private String reimburser;

          @ApiModelProperty("审批状态（审批状态（0表示已驳回，2表示待审批，1表示已通过）")
      @TableField("approval_status")
  private String approvalStatus;

          @ApiModelProperty("提交时间")
      @TableField("delivery_time")
      @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date deliveryTime;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("假删（0表示未删，1表示删除）")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
