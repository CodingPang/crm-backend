package com.greatgump.crm.dto.finance.cost;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 只装id与customerName的Customer
 * @date 2022/10/18 17:08
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerList {
  @ApiModelProperty("主键")
  private long id;

  @ApiModelProperty("客户名")
  private String customerName;
}
