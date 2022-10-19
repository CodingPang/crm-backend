package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.entity.Contact;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkorderDto3 {
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
    private User initiator;

    @ApiModelProperty("处理人")
    @TableField("handler")
    private User handler;

    @ApiModelProperty("工单状态(0:待处理，1：处理中，2：已完结)")
    @TableField("work_order_status")
    private Integer workOrderStatus;


    @ApiModelProperty("关联客户")
    @TableField("customer_name")
    private Customer customerName;

    @ApiModelProperty("工单内容")
    @TableField("work_order_details")
    private String workOrderDetails;

    @ApiModelProperty("联系人")
    @TableField("linkman")
    private Contact linkman;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("删除（0未删，1删除")
    @TableField("is_delete")
    private String isDelete;

    @ApiModelProperty("附件")
    @TableField("accessory")
    private String accessory;
}
