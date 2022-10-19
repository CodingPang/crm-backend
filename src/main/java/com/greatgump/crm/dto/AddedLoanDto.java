package com.greatgump.crm.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddedLoanDto {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    private Long id;

    @ApiModelProperty("关联客户")
    private Integer customerId;

    @ApiModelProperty("关联订单")
    private Integer orderId;

     @ApiModelProperty("关联商机")
    private Integer businessId;

    @ApiModelProperty("借款金额")
    private BigDecimal loanAmount;

    @ApiModelProperty("提交人员")
    private String submitted;

    @ApiModelProperty("借款部门")
    private Integer deptId;

    @ApiModelProperty("借款原因")
    private String cause;

    @ApiModelProperty("相关附件")
    private String relevant;

    @ApiModelProperty("提交时间")
    private Date submission_time;

    @ApiModelProperty("审批状态（1表示已通过，2表示待审批，0表示已驳回）")
    private Integer approval_status;

    @ApiModelProperty("审批人员")
    private String approver;

    @ApiModelProperty("审批时间")
    private Date approval_time;

    @ApiModelProperty("申请时间")
    private Date appplication_time;

    @ApiModelProperty("申请人员")
    private Integer userId;




}
