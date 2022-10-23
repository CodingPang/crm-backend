package com.greatgump.crm.dto.clue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel(value = "Clue对象", description = "线索管理")
public class ClueDept {
    @ApiModelProperty("自增")
    private Long dept_no;

    @ApiModelProperty("线索来源")
    private String dept_name;
}
