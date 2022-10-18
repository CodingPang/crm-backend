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
@TableName("t_back_plan")
@ApiModel(value = "BackPlan对象", description = "回款计划")
public class BackPlan implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("系统编号")
  @TableField("back_no")
  private String backNo;

  @ApiModelProperty("计划回款总金额(应该来自于订单)")
  @TableField("plan_back_total")
  private BigDecimal planBackTotal;

  @ApiModelProperty("回款状态(0表示未完成，1表示已完成，2表示还款中，3表示已逾期)")
  @TableField("back_status")
  private Integer backStatus;


  @ApiModelProperty("关联客户(外键)")
  @TableField("customer_id")
  private Customer customer;

  @ApiModelProperty("关联订单(外键)")
  @TableField("order_id")
  private Order order;

  @ApiModelProperty("回款期数(一共需要多少期)")
  @TableField("plan_back_count")
  private String planBackCount;

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

  @ApiModelProperty("假删(0代表未删，1代表删除)")
  @TableField("is_delete")
  @TableLogic
  private Integer isDelete;

}
