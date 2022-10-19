package com.greatgump.crm.dto.productlibrary;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddAssortDto {
    @ApiModelProperty("产品分类")
    private String assortName;
}
