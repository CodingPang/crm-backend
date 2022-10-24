package com.greatgump.crm.dto.workorder;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: zhuiyi
 * @CreatTime: 2022/10/23 20:30
 **/
@Data
public class WorkOrderOther {
    @ApiModelProperty("当前工单的id")
    private Integer currentOrderId;
    @ApiModelProperty("选择的人员id")
    private Integer choosePersonId;
    @ApiModelProperty("转交的原因")
    private String reason;
}
