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
import java.math.BigDecimal;
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
  @TableName("t_offer")
  @ApiModel(value = "Offer对象", description = "")
  public class Offer implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("主键，自增")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("单号")
      @TableField("odd_num")
  private String oddNum;

          @ApiModelProperty("创建时间")
      @TableField("creation_date")
      @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date creationDate;

          @ApiModelProperty("客户id")
      @TableField("customer_id")
  private Long customerId;

          @ApiModelProperty("报价人id")
      @TableField("saler_id")
  private Long salerId;

          @ApiModelProperty("联系人id")
      @TableField("contacts_id")
  private Long contactsId;

          @ApiModelProperty("售价总额")
      @TableField("price")
  private BigDecimal price;

          @ApiModelProperty("折扣率")
      @TableField("discount_tate")
  private String discountTate;

          @ApiModelProperty("报价总额")
      @TableField("offer")
  private BigDecimal offer;

          @ApiModelProperty("备注")
      @TableField("remake")
  private String remake;

          @ApiModelProperty("虚拟删除(0表示未删除，1表示删除)")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
