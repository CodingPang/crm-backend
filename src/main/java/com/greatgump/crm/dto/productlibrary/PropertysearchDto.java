package com.greatgump.crm.dto.productlibrary;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PropertysearchDto {
    @ApiModelProperty("属性名称")
    private String propertyName;
    @ApiModelProperty("开始时间")
    private Date start;
    @ApiModelProperty("结束时间")
    private Date end;
    @ApiModelProperty("页数")
    private Long current;
    @ApiModelProperty("条数")
    private Long size;
}
