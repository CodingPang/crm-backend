package com.greatgump.crm.controller.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
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
  * 顾客表
  * </p>
* @author team6
* @since 2022-10-15 04:12:20
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
      @Accessors(chain = true)
  @TableName("t_customer")
  @ApiModel(value = "Customer对象", description = "顾客表")
  public class Customer implements Serializable {

  private static final long serialVersionUID = 1L;
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("客户名称")
      @TableField("customer_name")
  private String customerName;

          @ApiModelProperty("省份")
      @TableField("province")
  private String province;

          @ApiModelProperty("城市")
      @TableField("city")
  private String city;

          @ApiModelProperty("企业规模id")
      @TableField("scale_id")
  private Long scaleId;

          @ApiModelProperty("客户类别id")
      @TableField("type_id")
  private Long typeId;

          @ApiModelProperty("客户来源id")
      @TableField("source_id")
  private Long sourceId;

          @ApiModelProperty("客户行业id")
      @TableField("industry_id")
  private Long industryId;

          @ApiModelProperty("客户归属人员id")
      @TableField("user_id")
  private Long userId;

          @ApiModelProperty("1是客户，0是公海")
      @TableField("is_customer")
  private Integer isCustomer;

          @ApiModelProperty("创建时间")
          @TableField(value = "create_time", fill = FieldFill.INSERT)
      @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date createTime;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("删除标记（1删除 0未删）")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
