package com.greatgump.crm.dto.finance.cost.comm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description  商机类 最小字段
 * @date 2022/10/20 19:28
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BusinessMiniDto {
  @ApiModelProperty("自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("商机标题")
  @TableField("bussiness_title")
  private String bussinessTitle;
}
