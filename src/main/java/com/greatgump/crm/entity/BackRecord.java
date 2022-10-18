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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@TableName("t_back_record")
@ApiModel(value = "BackRecord对象", description = "回款记录")
public class BackRecord implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("系统编号")
  @TableField("back_record_no")
  private String backRecordNo;

  @ApiModelProperty("回款计划id(外键)")
  @TableField("back_id")
  private BackPlan backplan;

  @ApiModelProperty("关联客户(外键)")
  @TableField("customer_id")
  private Customer customer;

  @ApiModelProperty("关联订单(外键)")
  @TableField("order_id")
  private Order order;

  @ApiModelProperty("实际回款日期")
  @TableField("back_date")
  private String backDate;

  @ApiModelProperty("实际回款金额")
  @TableField("back_money")
  private BigDecimal backMoney;

  @ApiModelProperty("回款期次(外键,来自于回款计划明细表)")
  @TableField("back_pland_id")
  private BackPlanDetail backPlanDetail;

  @ApiModelProperty("付款方式(0代表对公转账，1代表现金，2代表支票，")
  @TableField("pay_method")
  private Integer payMethod;

  @ApiModelProperty("收款人员(外键)")
  @TableField("user_id")
  private User user;

  @ApiModelProperty("审批人员(外键，审计)")
  @TableField("checker")
  private User checker;

  @ApiModelProperty("审批状态(0表示待审批，1表示已通过，2表示已驳回)")
  @TableField("check_status")
  private Integer checkStatus;

  @ApiModelProperty("审批时间")
  @TableField("check_time")
  private String checkTime;

  @ApiModelProperty("逾期天数")
  @TableField("overdue_days")
  private Integer overdueDays;

  @ApiModelProperty("提交人员")
  @TableField("submitter")
  private User submitter;

  @ApiModelProperty("提交时间")
  @TableField("submit_time")
  private String submitTime;

  @ApiModelProperty("备注被驳回的原因")
  @TableField("remark")
  private String remark;

  @ApiModelProperty("假删（0表示未删，1表示删除）")
  @TableField("is_delete")
  @TableLogic
  private Integer isDelete;
}
