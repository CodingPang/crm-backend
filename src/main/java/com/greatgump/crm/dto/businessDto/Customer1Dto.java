package com.greatgump.crm.dto.businessDto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Customer1Dto {
    @ApiModelProperty("姓名")
    private String customerName;
}
