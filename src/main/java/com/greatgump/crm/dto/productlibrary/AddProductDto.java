package com.greatgump.crm.dto.productlibrary;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddProductDto {
    @ApiModelProperty("产品编码")
    private String productCode;

    @ApiModelProperty("产品名称")
    private String productName;

    @ApiModelProperty("产品分类")
    private Integer classificationid;

    @ApiModelProperty("单位名称")
    private Integer unitid;

    @ApiModelProperty("属性名称")
    private Integer propertyId;

    private Date createdate;

    private BigDecimal price;

}
