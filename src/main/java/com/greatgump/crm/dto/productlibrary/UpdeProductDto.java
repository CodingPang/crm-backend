package com.greatgump.crm.dto.productlibrary;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.entity.Assort;
import com.greatgump.crm.entity.CalcUnit;
import com.greatgump.crm.entity.Property;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdeProductDto {
    @ApiModelProperty("id")
    private Long id;

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

}
