package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveDto {

    @ApiModelProperty("请假类型")
    private String leaveType;

    @ApiModelProperty("申请人员")
    private String applicant;

    @ApiModelProperty("请假原因")
    private String cause;

    @ApiModelProperty("开始时间")
    private Date startTime;

    @ApiModelProperty("结束时间")
    private Date endTime;

    @ApiModelProperty("请假天数")
    private Integer leaveDays;

    @ApiModelProperty("审批状态（1表示已通过，2表示待审批，0表示已驳回）")
    private String approvalStatus;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("假删")
    private Integer isDelete;
}
