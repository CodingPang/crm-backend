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
 * @since 2022-10-15 04:12:19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@TableName("t_back_plan_detail")
@ApiModel(value = "BackPlanDetail对象", description = "回款计划明细表")
public class BackPlanDetail implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("关联回款计划id")
  @TableField("back_plan_id")
  private BackPlan backPlan;

  @ApiModelProperty("回款第几期")
  @TableField("back_periods")
  private String backPeriods;

  @ApiModelProperty("计划回款日期")
  @TableField("back_date")
  private String backDate;

  @ApiModelProperty("本期回款占总账比率")
  @TableField("back_ratio")
  private Double backRatio;

  @ApiModelProperty("回款金额")
  @TableField("back_money")
  private BigDecimal backMoney;

  @ApiModelProperty("备注")
  @TableField("remark")
  private String remark;

  @ApiModelProperty("假删(0表示未删，1表示删除)")
  @TableField("is_delete")
  @TableLogic
  private Integer isDelete;



}
