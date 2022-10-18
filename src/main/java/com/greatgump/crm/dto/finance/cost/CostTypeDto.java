package com.greatgump.crm.dto.finance.cost;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description
 * @date 2022/10/18 16:17
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CostTypeDto {
  @ApiModelProperty("费用类型id")
  private Integer id;

  @ApiModelProperty("费用类型选项")
  private String costType;

}
