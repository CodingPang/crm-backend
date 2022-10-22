package com.greatgump.crm.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BussinessDictionaryDto {
    private int page;
    private int size;
    @ApiModelProperty("关联客户")
    private String customer;

    @ApiModelProperty("商机来源")
    private String businessOrigin;

    @ApiModelProperty("商机阶段")
    private String businessStage;

    @ApiModelProperty("时间")
    private String shapTime;
}
