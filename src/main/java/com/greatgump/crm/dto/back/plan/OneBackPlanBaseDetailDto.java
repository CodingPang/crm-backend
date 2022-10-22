package com.greatgump.crm.dto.back.plan;

import static com.greatgump.crm.utils.DiffDateTime.calculateTimeDifference;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @description 单条回款计划详情
 * @date 2022/10/19 18:47
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OneBackPlanBaseDetailDto {
  @ApiModelProperty("主键，自增")
  private Long id;

  @ApiModelProperty("系统编号")
  private String backNo;

  @ApiModelProperty("关联订单(外键)") // 订单表
  private OrderListDto order;

  @ApiModelProperty("回款第几期") // 回款计划明细表
  @TableField("back_periods")
  private String backPeriods;

  @ApiModelProperty("计划回款金额")
  @TableField("back_money")
  private BigDecimal planBackMoney;

  @ApiModelProperty("实际回款金额")
  private BigDecimal realBackMoney;

  @ApiModelProperty("当期未回款金额")
  private BigDecimal NotBackMoney;

  @ApiModelProperty("回款状态(0表示未完成，1表示已完成，2表示还款中，3表示已逾期)")
  private Integer backStatus;

  @ApiModelProperty("关联客户(外键)") // 客户表
  private CustomerList customer;

  @ApiModelProperty("计划回款日期") // 计划表
  @TableField("back_date")
  private String planBackDate;

  @ApiModelProperty("实际回款日期") // 回款明细表
  @TableField("back_date")
  private String realBackDate;

  @ApiModelProperty("逾期天数") // 回款记录表
  @TableField("overdue_days")
  private Integer overdueDays;


  @ApiModelProperty("创建时间")
  private String creationTime;

  @ApiModelProperty("更新时间")
  private String updateTime;


  @ApiModelProperty("付款方式(0代表对公转账，1代表现金，2代表支票，")
  @TableField("pay_method")
  private Integer payMethod;


// 以下字段回款计划暂时用不到

  @ApiModelProperty("计划回款总金额(应该来自于订单)")
  private BigDecimal planBackTotal;


/*  @ApiModelProperty("回款期数(一共需要多少期)")
  private String planBackCount;


  @ApiModelProperty("本期回款占总账比率")
  @TableField("back_ratio")
  private Double backRatio;*/


  @ApiModelProperty("备注")
  private String remark;



/*  @ApiModelProperty("假删(0代表未删，1代表删除)")
  @TableField("is_delete")
  @TableLogic
  private Integer isDelete;*/


  public OneBackPlanBaseDetailDto(Long id, String backNo, OrderListDto order, String backPeriods,
      BigDecimal planBackMoney, BigDecimal realBackMoney,
      Integer backStatus,
      CustomerList customer, String planBackDate, String realBackDate,
      String creationTime, String updateTime, Integer payMethod, BigDecimal planBackTotal,
      String remark) {
    this.id = id;
    this.backNo = backNo;
    this.order = order;
    this.backPeriods = backPeriods;
    this.planBackMoney = planBackMoney;
    this.realBackMoney = realBackMoney;
    NotBackMoney = realBackMoney.subtract(planBackMoney);
    this.backStatus = backStatus;
    this.customer = customer;
    this.planBackDate = planBackDate;
    this.realBackDate = realBackDate;
    this.overdueDays = calculateTimeDifference(planBackDate,realBackDate,"yyyy-MM-dd");
    this.creationTime = creationTime;
    this.updateTime = updateTime;
    this.payMethod = payMethod;
    this.planBackTotal = planBackTotal;
    this.remark = remark;
  }
}
