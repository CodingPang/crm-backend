package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkorderDto {

    @ApiModelProperty("工单编号")
    @TableField("work_order_number")
    private Integer workOrderNumber;

    @ApiModelProperty("工单标题")
    @TableField("repair_order_title")
    private String repairOrderTitle;

    @ApiModelProperty("发起时间")
    @TableField("start_time")
    private Date startTime;

    @ApiModelProperty("发起人")
    @TableField("initiator")
    private String initiator;

    @ApiModelProperty("处理人")
    @TableField("handler")
    private String handler;

    @ApiModelProperty("工单状态(0:待处理，1：处理中，2：已完结)")
    @TableField("work_order_status")
    private Integer workOrderStatus;

    @ApiModelProperty("紧急程度")
    @TableField("emergency_degree")
    private Integer emergencyDegree;


//    @ApiModelProperty("备注")
//    @TableField("remark")
//    private String remark;
//
//    @ApiModelProperty("删除（0未删，1删除")
//    @TableField("is_delete")
//    private String isDelete;

}
