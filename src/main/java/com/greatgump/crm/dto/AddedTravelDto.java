package com.greatgump.crm.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddedTravelDto {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
      private Long id;

    @ApiModelProperty("关联客户")
    private Integer customerId;

    @ApiModelProperty("关联订单")
    private Integer orderId;

    @ApiModelProperty("相关附件")
    private String relevant;

    @ApiModelProperty("出差地址")
    private String address;

    @ApiModelProperty("开始时间")
    private Date startTime;

    @ApiModelProperty("出差天数")
    private Integer travelDays;

    @ApiModelProperty("结束时间")
    private Date endTime;

    @ApiModelProperty("申请人员")
    private String applicant;

    @ApiModelProperty("出差原因")
    private String cause;

    @ApiModelProperty("审批状态（1表示已通过，2表示待审批，0表示已驳回）")
    private Integer approvalStatus;







}
