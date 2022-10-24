package com.greatgump.crm.dto.productlibrary;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddPropertyDto {
    @ApiModelProperty("属性名称")
    private String propertyName;

    @ApiModelProperty("属性值")
    private String propertyValue;
}
