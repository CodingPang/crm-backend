package com.greatgump.crm.dto.productlibrary;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddPropertyDto {
    @ApiModelProperty("属性名称")
    private String propertyName;

    @ApiModelProperty("属性值")
    private String propertyValue;

    @ApiModelProperty("创建日期")
    @TableField("creation_date")
    private Date creationDate;
}
