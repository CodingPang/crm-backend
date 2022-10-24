package com.greatgump.crm.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkorderDto2 {

    //initiator_id 当前用户id handler_id
    @ApiModelProperty("关联客户--存客户对象-传id")
    private Integer customerId;

    @ApiModelProperty("关联订单编号--传id")
    private Integer orderId;

    @ApiModelProperty("紧急程度")
    private Integer emergency;

    @ApiModelProperty("工单标题")
    private String title;

    @ApiModelProperty("工单内容")
    private String content;

    @ApiModelProperty("附件上传成功后 返回给你的 url")
    private String attachment;

    @ApiModelProperty("当前工单的id--（编辑的时候必传--新增的时候不用传）")
    private Integer workOrderId;

}
