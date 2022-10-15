package com.greatgump.crm.controller.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
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
  @TableName("t_order")
  @ApiModel(value = "Order对象", description = "")
  public class Order implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("自增主建")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("关联名称(外键，客户表id)")
      @TableField("customer_id")
  private Long customerId;

          @ApiModelProperty("订单标题")
      @TableField("order_title")
  private String orderTitle;

          @ApiModelProperty("审批状态(0代表是已驳回，1代表已通过，2代表待审批)")
      @TableField("oder_status")
  private String oderStatus;

          @ApiModelProperty("订单总额")
      @TableField("oder_total")
  private BigDecimal oderTotal;

          @ApiModelProperty("签单日期")
      @TableField("order_date")
  private String orderDate;

          @ApiModelProperty("已回款金额")
      @TableField("total_res")
  private BigDecimal totalRes;

          @ApiModelProperty("已开票金额")
      @TableField("total_ticket")
  private BigDecimal totalTicket;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("虚拟删除(0是未删，1是删除)")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
