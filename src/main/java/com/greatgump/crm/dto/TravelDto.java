package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Order;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelDto {

    @ApiModelProperty("所有的用户")
    private List<Customer> customerList;

    @ApiModelProperty("所有订单")
    private List<Order> OrderList;

    @ApiModelProperty("申请人员")
    @TableField("applicant")
    private String applicant;

    @ApiModelProperty("出差原因")
    @TableField("cause")
    private String cause;

    @ApiModelProperty("开始时间")
    @TableField("start_time")
    private Date startTime;

    @ApiModelProperty("结束时间")
    @TableField("end_time")
    private Date endTime;

    @ApiModelProperty("出差天数")
    @TableField("travel_days")
    private Integer travelDays;

    @ApiModelProperty("审批状态（1表示已通过，2表示待审批，0表示已驳回)")
    @TableField("approval_status")
    private String approvalStatus;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("假删")
    @TableField("is_delete")
    private Integer isDelete;
}
