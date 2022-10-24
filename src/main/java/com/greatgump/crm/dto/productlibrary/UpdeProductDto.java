package com.greatgump.crm.dto.productlibrary;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdeProductDto {
    @ApiModelProperty("id--必传")
    private Integer id;

    @ApiModelProperty("产品编码")
    private String productCode;

    @ApiModelProperty("产品名称")
    private String productName;

    @ApiModelProperty("产品分类")
    private Integer classificationid;

    @ApiModelProperty("单位名称")
    private Integer unitid;

    @ApiModelProperty("属性--选中的id 封装为数组传递")
    private List<Integer> propertyIdList;
    @ApiModelProperty("属性--图片url 封装为数组传递")
    private List<String> photoUrlList;

}
