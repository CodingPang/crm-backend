package com.greatgump.crm.dto.customerDetails;

import io.swagger.annotations.ApiModel;
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
@ApiModel(value = "Clue对象", description = "线索管理")
public class ClueWorKOrderDto {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("工单编号")
    private String workOrderNumber;

    @ApiModelProperty("工单标题")
    private String repairOrderTitle;

    @ApiModelProperty("发起时间")
    private Date startTime;

    @ApiModelProperty("发起人员")
    private String initiatorId;

    @ApiModelProperty("我方处理人员")
    private String handlerId;

    @ApiModelProperty("订单状态")
    private String workorderStatus;

    @ApiModelProperty("订单状态")
    private String urgent;


}
