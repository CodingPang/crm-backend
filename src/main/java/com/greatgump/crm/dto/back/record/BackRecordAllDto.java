package com.greatgump.crm.dto.back.record;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.dto.back.plan.BackPlanDetailDto;
import com.greatgump.crm.dto.finance.cost.CustomerList;
import com.greatgump.crm.dto.finance.cost.OrderListDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author CodingPang
 * @version V1.0
 * @description 回款记录 全查询
 * @date 2022/10/19 15:32
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel(value = "BackRecordAllDto对象", description = "回款记录全查询对象")
public class BackRecordAllDto {
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("系统编号")
  @TableField("back_record_no")
  private String backRecordNo;

  @ApiModelProperty("关联订单")
  @TableField("order_id")
  private OrderListDto order;

  @ApiModelProperty("关联客户(外键)")
  @TableField("customer_id")
  private CustomerList customer;

  @ApiModelProperty("回款期次(外键,来自于回款计划明细表)")
  @TableField("back_pland_id")
  private BackPlanDetailDto backPlanDetail;

/*  @ApiModelProperty("回款计划")
  @TableField("back_id")
  private BackPlanDto backplan;*/

  @ApiModelProperty("实际回款金额")
  @TableField("back_money")
  private BigDecimal backMoney;

  @ApiModelProperty("实际回款日期")
  @TableField("back_date")
  private String backDate;

  @ApiModelProperty("审批状态(0表示待审批，1表示已通过，2表示已驳回)")
  @TableField("check_status")
  private Integer checkStatus;


/*  @ApiModelProperty("提交时间")
  @TableField("submit_time")
  private String submitTime;


  @ApiModelProperty("付款方式(0代表对公转账，1代表现金，2代表支票，")
  @TableField("pay_method")
  private Integer payMethod;

  @ApiModelProperty("收款人员(外键)")
  @TableField("user_id")
  private ReceiverDto user;*/



/*  @ApiModelProperty("逾期天数")
  @TableField("overdue_days")
  private Integer overdueDays;



  @ApiModelProperty("备注被驳回的原因")
  @TableField("remark")
  private String remark;*/
}
