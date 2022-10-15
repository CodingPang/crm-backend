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
  @TableName("t_follow")
  @ApiModel(value = "Follow对象", description = "")
  public class Follow implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("自增主键")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("关联客户")
      @TableField("customer")
  private String customer;

          @ApiModelProperty("联系人")
      @TableField("person")
  private String person;

          @ApiModelProperty("跟进方式")
      @TableField("follow_method")
  private String followMethod;

          @ApiModelProperty("跟进人员")
      @TableField("follow_people")
  private String followPeople;

          @ApiModelProperty("跟进时间")
      @TableField("followdate")
      @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date followdate;

          @ApiModelProperty("跟进内容")
      @TableField("follow_context")
  private String followContext;

          @ApiModelProperty("备注")
      @TableField("remake")
  private String remake;

          @ApiModelProperty("虚拟删除(0是未删，1是删除)")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
