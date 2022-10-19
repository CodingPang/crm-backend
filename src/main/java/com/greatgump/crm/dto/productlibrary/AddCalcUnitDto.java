package com.greatgump.crm.dto.productlibrary;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddCalcUnitDto {
    @ApiModelProperty("单位名称")
    private String unitName;
}
