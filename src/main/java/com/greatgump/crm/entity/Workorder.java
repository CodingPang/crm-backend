package com.greatgump.crm.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工单
 * @TableName t_workorder
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("t_workorder")
public class Workorder implements Serializable {
    /**
     * 主键，自动递增，非空
     */
    @ApiModelProperty("主键")
    private Integer id;

    /**
     * 工单编号
     */
    @ApiModelProperty("工单编号")
    @TableField("work_order_number")
    private String workOrderNumber;

    /**
     * 工单标题
     */
    @TableField("repair_order_title")
    @ApiModelProperty("工单标题")
    private String repairOrderTitle;

    /**
     * 发起时间
     */
    @TableField("start_time")
    @ApiModelProperty("发起时间")
    private Date startTime;

    /**
     * 发起人
     */
    @TableField("initiator_id")
    @ApiModelProperty("发起人")
    private Integer initiatorId;

    /**
     * 处理人
     */
    @TableField("handler_id")
    @ApiModelProperty("处理人")
    private Integer handlerId;

    /**
     * 工单状态(1:待处理，2：处理中，3：已完结)
     */
    @TableField("workorder_status")
    @ApiModelProperty("工单状态(1:待处理，2：处理中，3：已完结)")
    private Integer workorderStatus;

    /**
     * 关联客户
     */
    @TableField("customer_id")
    @ApiModelProperty("关联客户")
    private Integer customerId;

    /**
     * 联系人
     */
    @TableField("contact_id")
    @ApiModelProperty("联系人")
    private Integer contactId;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String note;

    /**
     * 假删（0：未删除，1：删除）
     */
    @TableLogic
    @TableField("is_delete")
    @ApiModelProperty("假删（0：未删除，1：删除）")
    private Integer isDelete;

    /**
     * 紧急程度（1：非常紧急，2：紧急，3：一般）
     */
    @ApiModelProperty("紧急程度（1：非常紧急，2：紧急，3：一般）")
    private Integer urgent;

    /**
     * 附件
     */
    @ApiModelProperty("附件")
    private String attachment;

    /**
     * 工单内容
     */
    @ApiModelProperty("工单内容")
    private String content;

    /**
     * 订单id
     */
    @TableField("order_id")
    @ApiModelProperty("订单id")
    private Integer orderId;
    /**
     * 转交原因
     */
    @TableField("reason")
    @ApiModelProperty("转交原因")
    private String reason;

    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private String customerName;

    @TableField(exist = false)
    private String contactName;

    @TableField(exist = false)
    private String launchPerson;

    @TableField(exist = false)
    private String handlePerson;

}