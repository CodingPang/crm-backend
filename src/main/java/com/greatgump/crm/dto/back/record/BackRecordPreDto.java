package com.greatgump.crm.dto.back.record;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.OrderDto;
import com.greatgump.crm.dto.back.common.ReceiverDto;
import com.greatgump.crm.dto.back.plan.BackPlanQueryAllDto;
import com.greatgump.crm.dto.power.UserDto;
import com.greatgump.crm.entity.BackPeriod;
import com.greatgump.crm.entity.TransferType;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 回款记录 数据传输层
 * @date 2022/10/14 15:23
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BackRecordPreDto implements Serializable {
  private static final long serialVersionUID = 1L;
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("系统编号")
  @TableField("back_record_no")
  private String backRecordNo;

  @ApiModelProperty("回款计划id(外键)")
  @TableField("back_id")
  private List<BackPlanQueryAllDto> backPlan;

  @ApiModelProperty("关联客户(外键)")
  @TableField("customer_id")
  private List<CustomerDto> customerId;

  @ApiModelProperty("关联订单(外键)")
  @TableField("order_id")
  private List<OrderDto> orderId;

  @ApiModelProperty("实际回款日期")
  @TableField("back_date")
  private String backDate;

  @ApiModelProperty("实际回款金额")
  @TableField("back_money")
  private BigDecimal backMoney;

  @ApiModelProperty("回款期次(外键)")
  @TableField("back_plan_id")
  private List<BackPeriod> backPlanId;

  @ApiModelProperty("付款方式(外键)")
  @TableField("transfer_id")
  private List<TransferType> transferId;

  @ApiModelProperty("收款人员(外键)")
  @TableField("user_id")
  private List<ReceiverDto> userId;

  @ApiModelProperty("逾期天数")
  @TableField("overdue_days")
  private Integer overdueDays;

  @ApiModelProperty("备注")
  @TableField("remark")
  private String remark;

  @ApiModelProperty("假删（0表示未删，1表示删除）")
  @TableField("is_delete")
  @TableLogic
  private Integer isDelete;

  public BackRecordPreDto(List<CustomerDto> customerId,
      List<OrderDto> orderId, List<BackPeriod> backPlanId, List<TransferType> transferId,
      List<ReceiverDto> userId) {
    this.customerId = customerId;
    this.orderId = orderId;
    this.backPlanId = backPlanId;
    this.transferId = transferId;
    this.userId = userId;
  }

  public BackRecordPreDto(List<BackPlanQueryAllDto> backPlan, List<CustomerDto> customerId,
      List<OrderDto> orderId, List<BackPeriod> backPlanId, List<TransferType> transferId,
      List<ReceiverDto> userId) {
    this.backPlan = backPlan;
    this.customerId = customerId;
    this.orderId = orderId;
    this.backPlanId = backPlanId;
    this.transferId = transferId;
    this.userId = userId;
  }


  // 实际回款金额
  public BackRecordPreDto(BigDecimal backMoney) {
    this.backMoney = backMoney;
  }
}
