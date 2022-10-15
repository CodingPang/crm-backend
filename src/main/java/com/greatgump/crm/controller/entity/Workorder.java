package com.greatgump.crm.controller.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
* <p>
  * 工单
  * </p>
* @author team6
* @since 2022-10-15 04:12:20
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
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
      @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
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

          @ApiModelProperty("关联客户")
      @TableField("customer_name")
  private String customerName;

          @ApiModelProperty("工单内容")
      @TableField("work_order_details")
  private String workOrderDetails;

          @ApiModelProperty("联系人")
      @TableField("linkman")
  private String linkman;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("假删（0：已删除，1：未删除）")
      @TableField("is_delete")
      @TableLogic
  private String isDelete;

          @ApiModelProperty("紧急程度（0：非常紧急，1：紧急，2：一般）")
      @TableField("emergency_degree")
  private Integer emergencyDegree;

}
