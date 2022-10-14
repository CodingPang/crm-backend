package com.greatgump.crm.dto;

import com.greatgump.crm.entity.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductBoxDto {
    @ApiModelProperty("所有产品分类")
    private List<Assort> assortList;

    @ApiModelProperty("所有计量单位")
    private List<CalcUnit> calcUnitList;

    @ApiModelProperty("所有产品属性")
    private List<Property> propertyList;


}
