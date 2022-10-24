package com.greatgump.crm.dto.customerDetails;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class BelongRecord {
    @ApiModelProperty("归属人员")
    private  String userName;

    @ApiModelProperty("归属起始")
    private Date beginTime;

    @ApiModelProperty("归属截至")
    private Date endTime;

    @ApiModelProperty("操作人员")
    private String operationName;

    @ApiModelProperty("操作时间")
    private Date operationTime;

}
