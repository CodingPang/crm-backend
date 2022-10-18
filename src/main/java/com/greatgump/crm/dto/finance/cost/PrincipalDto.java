package com.greatgump.crm.dto.finance.cost;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author CodingPang
 * @version V1.0
 * @description 负责人员
 * @date 2022/10/18 17:16
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel(value = "PrincipalDto对象", description = "负责人员")
public class PrincipalDto {
  @ApiModelProperty("主键，自增")
  private Long id;

  @ApiModelProperty("用户名")
  private String username;
}
