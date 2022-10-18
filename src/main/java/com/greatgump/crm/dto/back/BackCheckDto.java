package com.greatgump.crm.dto.back;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description
 * @date 2022/10/14 21:39
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BackCheckDto {
  /*@ApiModelProperty("主键，自增")
  private Integer id;*/

  @ApiModelProperty("审批状态(0表示待审批，1表示已通过，2表示已驳回)")
  private Integer checkStatus;

  @ApiModelProperty("备注被驳回的原因")
  private String remark;
}
