package com.greatgump.crm.dto;

import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Dept;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetailDto {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    private Long id;

    @ApiModelProperty("借款金额")
    private BigDecimal loanAmount;

    @ApiModelProperty("提交人员")
    private String submitted;

    @ApiModelProperty("借款部门")
    private Dept deptId;

    @ApiModelProperty("关联用户")
    private Customer customerId;

    @ApiModelProperty("借款原因")
    private String cause;

    @ApiModelProperty("相关附件")
    private String relevant;

    @ApiModelProperty("提交时间")
    private Date submission_time;

    @ApiModelProperty("审批状态（1表示已通过，2表示待审批，0表示已驳回）")
    private Integer approvalStatus;

    @ApiModelProperty("审批人员")
    private String approver;

    @ApiModelProperty("审批时间")
    private Date approval_time;

}
