package com.greatgump.crm.dto.productlibrary;

import com.greatgump.crm.entity.Assort;
import com.greatgump.crm.entity.CalcUnit;
import com.greatgump.crm.entity.Property;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QueryProductDto {
    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("产品编码")
    private String productCode;

    @ApiModelProperty("产品名称")
    private String productName;

    @ApiModelProperty("产品分类")
    private Assort assort;

    @ApiModelProperty("单位名称")
    private CalcUnit calcUnit;

    @ApiModelProperty("属性名称")
    private Property property;

}
