package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


public class WorkorderDto {
    @ApiModelProperty("主键，自动递增，非空")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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


}
