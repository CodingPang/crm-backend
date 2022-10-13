package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
* <p>
  * 回款审批
  * </p>
* @author team6
* @since 2022-10-14 01:52:00
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
      @Accessors(chain = true)
  @TableName("t_back_check")
  @ApiModel(value = "BackCheck对象", description = "回款审批")
  public class BackCheck implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("主键，自增")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("系统编号")
      @TableField("back_check_no")
  private String backCheckNo;

          @ApiModelProperty("关联订单(外键，订单)")
      @TableField("associated _order")
  private String associatedOrder;

          @ApiModelProperty("回款期次")
      @TableField("back_period")
  private String backPeriod;

          @ApiModelProperty("回款金额")
      @TableField("back_money")
  private BigDecimal backMoney;

          @ApiModelProperty("回款日期")
      @TableField("back_date")
  private String backDate;

          @ApiModelProperty("审批状态（0表示已驳回，2表示待审批，1表示已通过）")
      @TableField("check_status")
  private String checkStatus;

          @ApiModelProperty("提交人员")
      @TableField("submitter")
  private String submitter;

          @ApiModelProperty("提交时间")
      @TableField("submit_time")
  private String submitTime;

          @ApiModelProperty("审批人员(财务，审计)")
      @TableField("checker")
  private String checker;

          @ApiModelProperty("审批时间")
      @TableField("check_time")
  private String checkTime;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("假删（0表示未删，1表示删除）")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
