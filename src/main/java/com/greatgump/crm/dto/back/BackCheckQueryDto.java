package com.greatgump.crm.dto.back;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.greatgump.crm.entity.BackPlan;
import com.greatgump.crm.entity.BackPlanDetail;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Order;
import com.greatgump.crm.entity.User;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 回款审批 全查询 数据传输层
 * @date 2022/10/17 22:05
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BackCheckQueryDto {
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("系统编号")
  @TableField("back_record_no")
  private String backRecordNo;

  @ApiModelProperty("关联订单")
  @TableField("order_id")
  private Order order;

  @ApiModelProperty("回款期次(外键,来自于回款计划明细表)")
  @TableField("back_pland_id")
  private BackPlanDetail backPlanDetail;

  @ApiModelProperty("回款计划")
  @TableField("back_id")
  private BackPlan backplan;

  @ApiModelProperty("实际回款金额")
  @TableField("back_money")
  private BigDecimal backMoney;

  @ApiModelProperty("实际回款日期")
  @TableField("back_date")
  private String backDate;

  @ApiModelProperty("关联客户(外键)")
  @TableField("customer_id")
  private Customer customer;

  @ApiModelProperty("审批状态(0表示待审批，1表示已通过，2表示已驳回)")
  @TableField("check_status")
  private Integer checkStatus;

  @ApiModelProperty("提交时间")
  @TableField("submit_time")
  private String submitTime;


  @ApiModelProperty("付款方式(0代表对公转账，1代表现金，2代表支票，")
  @TableField("pay_method")
  private Integer payMethod;

  @ApiModelProperty("收款人员(外键)")
  @TableField("user_id")
  private User user;



  @ApiModelProperty("逾期天数")
  @TableField("overdue_days")
  private Integer overdueDays;



  @ApiModelProperty("备注被驳回的原因")
  @TableField("remark")
  private String remark;

  @ApiModelProperty("假删（0表示未删，1表示删除）")
  @TableField("is_delete")
  @TableLogic
  private Integer isDelete;
}
