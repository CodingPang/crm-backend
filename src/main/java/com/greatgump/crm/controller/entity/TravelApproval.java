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
  * 
  * </p>
* @author team6
* @since 2022-10-15 04:12:20
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
      @Accessors(chain = true)
  @TableName("t_travel_approval")
  @ApiModel(value = "TravelApproval对象", description = "")
  public class TravelApproval implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("主键,自增")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("出差原因")
      @TableField("travel_reason")
  private String travelReason;

          @ApiModelProperty("出差天数")
      @TableField("travel_days")
  private Integer travelDays;

          @ApiModelProperty("审批状态(0表示已驳回,1表示已通过,2表示待审批)")
      @TableField("approval_status")
  private Integer approvalStatus;

          @ApiModelProperty("提交人员")
      @TableField("submit_personnel")
  private String submitPersonnel;

          @ApiModelProperty("提交时间")
      @TableField("submission_time")
      @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date submissionTime;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("假删(0表示未删,1表示删除)")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
