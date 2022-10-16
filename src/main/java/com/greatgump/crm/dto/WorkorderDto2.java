package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Order;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkorderDto2 {
    @ApiModelProperty("自增主建")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("关联客户")
    @TableField("customer_name")
    private Customer customerName;

    @ApiModelProperty("关联订单")
    @TableField("work_order_number")
    private Order workOrderNumber;

    @ApiModelProperty("紧急程度")
    @TableField("emergency_degree")
    private Integer emergencyDegree;

    @ApiModelProperty("工单标题")
    @TableField("repair_order_title")
    private String repairOrderTitle;

    @ApiModelProperty("工单内容")
    @TableField("work_order_details")
    private String workOrderDetails;


    public WorkorderDto2(List<Customer> customers, List<OrderDto> orderDtos, List<WorkorderDto> workorderDtos) {
    }
}
