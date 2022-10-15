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
  * 访客计划
  * </p>
* @author team6
* @since 2022-10-15 04:12:20
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
      @Accessors(chain = true)
  @TableName("t_visitor")
  @ApiModel(value = "Visitor对象", description = "访客计划")
  public class Visitor implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("自增")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("开始时间")
      @TableField("start_time")
      @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date startTime;

          @ApiModelProperty("计划标题")
      @TableField("plan_title")
  private String planTitle;

          @ApiModelProperty("关联客户")
      @TableField("customer_name")
  private String customerName;

          @ApiModelProperty("负责人员")
      @TableField("person_charge")
  private String personCharge;

          @ApiModelProperty("计划进度(0表示取消计划，1表示进行中，2表示已完成)")
      @TableField("planned_progress")
  private String plannedProgress;

          @ApiModelProperty("重要程度(0表示不重要，1表示紧急不重要，2表示重要不紧急，3表示重要且紧急)")
      @TableField("Importance")
  private String importance;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("假删（0表示未删，1表示删除）")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
