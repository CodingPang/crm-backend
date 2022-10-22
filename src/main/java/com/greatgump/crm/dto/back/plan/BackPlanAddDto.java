package com.greatgump.crm.dto.back.plan;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @description 回款计划新增/预更新使用的Dto
 * @date 2022/10/20 0:18
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BackPlanAddDto {
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  // 这部分插入到回款计划表
  @ApiModelProperty("系统编号")
  @TableField("back_no")
  private String backNo;


  // 基本信息部分
  @ApiModelProperty("关联客户")
  private CustomerList customerList;

  @ApiModelProperty(value = "关联订单")
  private OrderListDto order;

  // 设置回款计划(插入到回款计划明细表)

  // 1、期次，插入到回款计划明细表
  @ApiModelProperty("回款期次")
  @TableField("back_periods")
  private String backPeriods;

  @ApiModelProperty("计划回款日期")
  @TableField("back_date")
  private String backDate;

  @ApiModelProperty("计划回款占比(订单总额)比率")
  @TableField("back_ratio")
  private Double backRatio;

  @ApiModelProperty("计划回款金额")
  @TableField("back_money")
  private BigDecimal backMoney;

  // 这个值插入到"回款计划表"(t_back_plan)
  @ApiModelProperty("回款总期数(一共需要多少期)")
  @TableField("plan_back_count")
  private String planBackCount;

}
