package com.greatgump.crm.dto.productlibrary;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddProductDto {
    @ApiModelProperty("产品编码")
    private String productCode;

    @ApiModelProperty("产品名称")
    private String productName;

    @ApiModelProperty("产品单价")
    private String price;

    @ApiModelProperty("产品分类---填对应多选框选中的的id")
    private Integer classId;

    @ApiModelProperty("单位名称---填对多选框选中的 id")
    private Integer unitId;

    @ApiModelProperty("属性名称---填选中的的分类的多个id ，封装成数组传过来")
    private List<Integer> propertyIdList;

    @ApiModelProperty("图片url列表---上传成功返回给你的图片的url地址 ，封装成数组传过来")
    private List<String> photoList;

}
