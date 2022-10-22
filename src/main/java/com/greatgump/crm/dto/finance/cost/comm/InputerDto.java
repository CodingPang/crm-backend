package com.greatgump.crm.dto.finance.cost.comm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author CodingPang
 * @version V1.0
 * @description 录入人员(会计)
 * @date 2022/10/20 19:13
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true) // 使用此注解解决了
@ApiModel(value = "InputerDto", description = "录入人员")
public class InputerDto {
  @ApiModelProperty("主键，自增")
  private Long id;

  @ApiModelProperty("录入人员用户名")
  private String username;

}
