package com.greatgump.crm.dto.finance.cost;

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
 * @description
 * @date 2022/10/18 19:02
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BusinessListDto {
  @ApiModelProperty("自增")
  private Long id;

  @ApiModelProperty("商机标题")
  @TableField("bussiness_title")
  private String bussinessTitle;

  @ApiModelProperty("商机来源")
  @TableField("bussiness_source")
  private Long bussinessSource;

  @ApiModelProperty("商机阶段")
  @TableField("bussiness_stage")
  private Long bussinessStage;
}
