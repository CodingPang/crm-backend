package com.greatgump.crm.dto.finance.cost.comm;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description Cost条件查询 通用类
 * @date 2022/10/20 7:28
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CostCommFuzzyQuery {
  @ApiModelProperty(value = "关键词", example = "")
  private String keyword;

  @ApiModelProperty("回款状态")
  private Integer back_status;

  @ApiModelProperty("费用来源(0表示电话营销，1表示主动来电，2表示客户介绍，3表示展会促销，4表示其他途径)")
  @TableField("cost_source")
  private Integer costSource;

  @ApiModelProperty("费用阶段(0表示需求获取，1表示首次拜访，2表示方案展示，3表示产品报价，4表示合同谈判，5表示合同签订)")
  @TableField("cost_stage")
  private Integer costStage;

  @ApiModelProperty(value = "最后跟进(开始时间)", example = "2022-10-08")
  private String start_back_date;

  @ApiModelProperty(value = "最后跟进(开始时间)", example = "2022-10-08")
  private String end_back_date;

}
