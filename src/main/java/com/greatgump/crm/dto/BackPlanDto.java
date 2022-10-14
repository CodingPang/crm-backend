package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Order;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author CodingPang
 * @version V1.0
 * @description
 * @date 2022/10/14 6:58
 * @since 1.0
 */

public class BackPlanDto {
  private static final long serialVersionUID = 1L;
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("系统编号")
  @TableField("back_no")
  private String backNo;

  @ApiModelProperty("计划回款日期")
  @TableField("plan_back_date")
  private String planBackDate;

  @ApiModelProperty("回款期次")
  @TableField("plan_back_count")
  private String planBackCount;

  @ApiModelProperty("计划回款金额")
  @TableField("plan_back_money")
  private BigDecimal planBackMoney;

  @ApiModelProperty("实际回款金额")
  @TableField("real_back_money")
  private BigDecimal realBackMoney;

  @ApiModelProperty("未回款金额")
  @TableField("not_back_money")
  private BigDecimal notBackMoney;

  @ApiModelProperty("付款方式(0代表对公转账，1代表现金，2代表支票，3代表本票)")
  @TableField("pay_mothod")
  private Integer payMothod;

  @ApiModelProperty("回款状态(若未回款，则是未回款，有回款需具体到期次)")
  private String backStatus;

  @ApiModelProperty("关联客户(外键)")
  private List<CustomerDto> customerId;

  @ApiModelProperty("关联订单")
  private List<OrderDto> order;

  @ApiModelProperty("实际回款日期")
  private String realBackDate;

  @ApiModelProperty("逾期天数")
  private Integer overdueDays;

  @ApiModelProperty("审批状态(0代表已驳回，1代表已通过，2代表审批中)")
  private Integer approvalStatus;

  @ApiModelProperty("创建时间")
  private String creationTime;

  @ApiModelProperty("更新时间")
  private String updateTime;

  @ApiModelProperty("备注")
  private String remark;

  @ApiModelProperty("假删(0代表未删，1代表删除)")
  @TableLogic
  private Integer isDelete;

  public BackPlanDto(List<CustomerDto> customerId, List<OrderDto> order) {
    this.customerId = customerId;
    this.order = order;
  }
}
