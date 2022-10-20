package com.greatgump.crm.dto.back.record;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.OrderDto;
import com.greatgump.crm.dto.back.common.ReceiverDto;
import com.greatgump.crm.dto.back.plan.BackPlanDetailDto;
import com.greatgump.crm.dto.finance.cost.CustomerList;
import com.greatgump.crm.dto.finance.cost.OrderListDto;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 新增回款记录 数据传输类
 * @date 2022/10/20 2:15
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BackRecordAddDto {

  @ApiModelProperty("系统编号")
  @TableField("back_no")
  private String backNo;

  @ApiModelProperty(value = "关联客户")
  @TableField("customer_id")
  private CustomerList customer;

  @ApiModelProperty(value = "关联订单")
  @TableField("order_id")
  private OrderListDto order;

  @ApiModelProperty(value = "实际回款日期")
  @TableField("back_date")
  private String realBackDate;

  @ApiModelProperty(value = "回款金额", required = true)
  @TableField("plan_back_total")
  private BigDecimal realBackTotal;

  @ApiModelProperty(value = "当前回款期数" ,required = true)
  @TableField("plan_back_count")
  private String planBackCount;

  @ApiModelProperty( value = "付款方式(0表示现金支付，1表示对公转账)", required = true)
  @TableField("pay_methods")
  private Integer payMethods;

  @ApiModelProperty(value = "收款人员", required = true)
  private ReceiverDto receiverDto;

  // 以上部分用于新增回款记录
  @ApiModelProperty("回款状态(0表示未完成，1表示已完成，2表示还款中，3表示已逾期)")
  @TableField("back_status")
  private Integer backStatus;


  @ApiModelProperty("审批状态(0代表已驳回，1代表已通过，2代表审批中)")
  @TableField("approval_status")
  private Integer approvalStatus;

  @ApiModelProperty("创建时间")
  @TableField("creation_time")
  private String creationTime;

  @ApiModelProperty("更新时间")
  @TableField("update_time")
  private String updateTime;

  @ApiModelProperty("备注")
  @TableField("remark")
  private String remark;


  public BackRecordAddDto(CustomerList customerId, OrderListDto order) {
    this.customer = customerId;
    this.order = order;
  }

  /**
   * 查询所有的回款计划
   *
   * @param id
   * @param backNo
   * @param order
   * @param backPlanDetailDto
   * @param backRecordPreDto
   * @param backStatus
   * @param customer
   */


  /**
   * 预编辑操作
   * @param customer
   * @param order
   * @param realBackDate
   * @param realBackTotal
   * @param planBackCount
   * @param payMethods
   * @param receiverDto
   */
  public BackRecordAddDto(CustomerList customer, OrderListDto order, String realBackDate,
      BigDecimal realBackTotal, String planBackCount, Integer payMethods, ReceiverDto receiverDto) {
    this.customer = customer;
    this.order = order;
    this.realBackDate = realBackDate;
    this.realBackTotal = realBackTotal;
    this.planBackCount = planBackCount;
    this.payMethods = payMethods;
    this.receiverDto = receiverDto;
  }
}
