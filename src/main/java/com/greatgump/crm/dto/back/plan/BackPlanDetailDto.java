package com.greatgump.crm.dto.back.plan;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 回款计划详情 数据传输层
 * @date 2022/10/16 19:14
 * @since 1.0
 */
@NoArgsConstructor
//@AllArgsConstructor
@Data
public class BackPlanDetailDto {

  @ApiModelProperty("主键id")
  private Long id;

  @ApiModelProperty("回款期次")
  @TableField("plan_back_count")
  private String planBackCount;

  @ApiModelProperty("计划回款金额")
  @TableField("plan_back_total")
  private BigDecimal planBackTotal;

  public BackPlanDetailDto(Long id, String planBackCount, BigDecimal planBackTotal) {
    this.id = id;
    this.planBackCount = planBackCount;
    this.planBackTotal = planBackTotal;
  }
}
