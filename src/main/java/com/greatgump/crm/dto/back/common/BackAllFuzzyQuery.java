package com.greatgump.crm.dto.back.common;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 回款管理通用 模糊查询
 * @date 2022/10/19 16:08
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BackAllFuzzyQuery {
  @ApiModelProperty(value = "关键词", example = "")
  private String keyword;

  @ApiModelProperty("回款状态")
  private Integer back_status;

  @ApiModelProperty(value = "回款日期(开始时间)", example = "2022-10-08")
  private String start_back_date;

  @ApiModelProperty(value = "回款日期(结束时间)", example = "2022-10-20")
  private String end_back_date;

  public BackAllFuzzyQuery(String keyword) {
    this.keyword = keyword;
  }

  public BackAllFuzzyQuery(Integer back_status) {
    this.back_status = back_status;
  }

  public BackAllFuzzyQuery(String start_back_date, String end_back_date) {
    this.start_back_date = start_back_date;
    this.end_back_date = end_back_date;
  }
}
