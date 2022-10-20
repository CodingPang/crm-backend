package com.greatgump.crm.dto.back.check;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 回款审批条件查询
 * @date 2022/10/20 9:29
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BackCheckFuzzyQuery {
  @ApiModelProperty(value = "关键词", example = "")
  private String keyword;

  @ApiModelProperty("审批状态")
  private Integer check_status;

  @ApiModelProperty(value = "提交日期(开始时间)", example = "2022-10-08")
  private String start_back_date;

  @ApiModelProperty(value = "提交日期(结束时间)", example = "2022-10-20")
  private String end_back_date;

  public BackCheckFuzzyQuery(String keyword) {
    this.keyword = keyword;
  }

  public BackCheckFuzzyQuery(Integer check_status) {
    this.check_status = check_status;
  }

  public BackCheckFuzzyQuery(String start_back_date, String end_back_date) {
    this.start_back_date = start_back_date;
    this.end_back_date = end_back_date;
  }
}
