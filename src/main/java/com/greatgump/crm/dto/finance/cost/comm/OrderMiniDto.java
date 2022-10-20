package com.greatgump.crm.dto.finance.cost.comm;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 订单类 最小的字段量
 * @date 2022/10/20 19:26
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderMiniDto {
  @ApiModelProperty(value = "自增主建", required = true)
  private Long id;

  @ApiModelProperty("订单编号")
  private String orderNo;

  @ApiModelProperty(value = "订单标题", required = true)
  private String orderTitle;

}
