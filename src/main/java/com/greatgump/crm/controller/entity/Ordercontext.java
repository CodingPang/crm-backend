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
  @TableName("t_ordercontext")
  @ApiModel(value = "Ordercontext对象", description = "")
  public class Ordercontext implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("自增主键")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("订单标题")
      @TableField("order_title")
  private String orderTitle;

          @ApiModelProperty("订单归属")
      @TableField("order_owner")
  private String orderOwner;

          @ApiModelProperty("关联客户")
      @TableField("order_customer")
  private String orderCustomer;

          @ApiModelProperty("关联商机")
      @TableField("order_opp")
  private String orderOpp;

          @ApiModelProperty("关联产品")
      @TableField("order_product")
  private String orderProduct;

          @ApiModelProperty("订单总额")
      @TableField("total")
  private String total;

          @ApiModelProperty("上传附件")
      @TableField("fujian")
  private String fujian;

          @ApiModelProperty("付款方式")
      @TableField("pay_method")
  private String payMethod;

          @ApiModelProperty("对方签订人")
      @TableField("your_sigh")
  private String yourSigh;

          @ApiModelProperty("我方签订人")
      @TableField("our_sigh")
  private String ourSigh;

          @ApiModelProperty("联系方式")
      @TableField("phone")
  private String phone;

          @ApiModelProperty("签订时间")
      @TableField("sighdate")
      @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date sighdate;

          @ApiModelProperty("备注")
      @TableField("remake")
  private String remake;

          @ApiModelProperty("虚拟删除(0是未删，1是删除)")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
