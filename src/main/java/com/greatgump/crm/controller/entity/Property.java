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
  * 产品属性
  * </p>
* @author team6
* @since 2022-10-15 04:12:20
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
      @Accessors(chain = true)
  @TableName("t_property")
  @ApiModel(value = "Property对象", description = "产品属性")
  public class Property implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("主键,自增")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("属性名称")
      @TableField("property_name")
  private String propertyName;

          @ApiModelProperty("属性值")
      @TableField("property_value")
  private String propertyValue;

          @ApiModelProperty("创建日期")
      @TableField("creation_date")
      @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date creationDate;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("假删(0表示未删,1表示删除)")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
