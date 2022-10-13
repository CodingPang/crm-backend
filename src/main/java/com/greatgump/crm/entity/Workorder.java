package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 工单
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_workorder")
@ApiModel(value = "Workorder对象", description = "工单")
public class Workorder implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @ApiModelProperty("工单状态(0:待处理，1：处理中，2：已完结)")
    @TableField("work_order_status")
    private Integer workOrderStatus;

    @ApiModelProperty("紧急程度")
    @TableField("emergency_degree")
    private String emergencyDegree;

    @ApiModelProperty("关联客户")
    @TableField("customer_name")
    private String customerName;

    @ApiModelProperty("工单内容")
    @TableField("work_order_details")
    private String workOrderDetails;

    @ApiModelProperty("联系人")
    @TableField("linkman")
    private String linkman;


}
