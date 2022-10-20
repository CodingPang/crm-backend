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
 * @description 提交人员
 * @date 2022/10/19 15:12
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel(value = "Submitter对象", description = "提交人员")
public class SubmitterDto {
  @ApiModelProperty("主键，自增")
  private Long id;

  @ApiModelProperty("用户名")
  private String username;
}
