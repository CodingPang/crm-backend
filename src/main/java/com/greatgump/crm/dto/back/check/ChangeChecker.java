package com.greatgump.crm.dto.back.check;

import com.baomidou.mybatisplus.annotation.TableField;
import com.greatgump.crm.dto.back.common.ReceiverDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 转他人审批
 * @date 2022/10/20 11:16
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChangeChecker {
  @ApiModelProperty("当前要修改的回款记录的id")
  private Long id;

  @ApiModelProperty("用户名")
  private ReceiverDto checker;

  @ApiModelProperty("备注被驳回的原因")
  private String remark;
}
