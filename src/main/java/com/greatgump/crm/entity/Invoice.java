package com.greatgump.crm.entity;

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
  * 发票
  * </p>
* @author team6
* @since 2022-10-14 01:52:00
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
      @Accessors(chain = true)
  @TableName("t_invoice")
  @ApiModel(value = "Invoice对象", description = "发票")
  public class Invoice implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("主键，自增")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("关联订单(外键)")
      @TableField("order_id")
  private Long orderId;

          @ApiModelProperty("关联客户(外键)")
      @TableField("customer_id")
  private Long customerId;

          @ApiModelProperty("开票日期")
      @TableField("invoice_date")
  private String invoiceDate;

          @ApiModelProperty("发票类型(1代表增值税专用发票)")
      @TableField("invoice_type")
  private Integer invoiceType;

          @ApiModelProperty("发票号码")
      @TableField("invoice_no")
  private Integer invoiceNo;

          @ApiModelProperty("开票金额")
      @TableField("invoice_money")
  private BigDecimal invoiceMoney;

          @ApiModelProperty("开票科目")
      @TableField("invoice_subject")
  private String invoiceSubject;

          @ApiModelProperty("开票人(外键，会计)")
      @TableField("invoicer")
  private String invoicer;

          @ApiModelProperty("录入员(外键，)")
      @TableField("inputor")
  private String inputor;

          @ApiModelProperty("创建时间")
      @TableField("creation_time")
  private String creationTime;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("假删(0代表未删，1代表删除)")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
