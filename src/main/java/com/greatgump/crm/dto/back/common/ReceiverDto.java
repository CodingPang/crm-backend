package com.greatgump.crm.dto.back.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author CodingPang
 * @version V1.0
 * @description 收款人员
 * @date 2022/10/19 15:17
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel(value = "ReceiverDto", description = "收款人员")
public class ReceiverDto {
  @ApiModelProperty(value = "主键，自增", required = true)
  private Long id;

  @ApiModelProperty("用户名")
  private String username;
}
