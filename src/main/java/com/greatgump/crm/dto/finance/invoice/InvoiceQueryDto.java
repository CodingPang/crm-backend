package com.greatgump.crm.dto.finance.invoice;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.OrderDto;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 发票查询专用 数据传输层
 * @date 2022/10/17 1:19
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InvoiceQueryDto {
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("关联订单")
  @TableField("order_id")
  private OrderDto order;

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

  @ApiModelProperty("关联客户")
  @TableField("customer_id")
  private CustomerDto customer;


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

  // 费用管理使用的构造器
  public InvoiceQueryDto(Long id, CustomerDto customer, String invoiceDate, Integer invoiceNo,
      BigDecimal invoiceMoney, String invoiceSubject) {
    this.id = id;
    this.customer = customer;
    this.invoiceDate = invoiceDate;
    this.invoiceNo = invoiceNo;
    this.invoiceMoney = invoiceMoney;
    this.invoiceSubject = invoiceSubject;
  }

  // 发票管理使用的有参构造
  public InvoiceQueryDto(Long id, OrderDto order, String invoiceDate, Integer invoiceType,
      Integer invoiceNo, BigDecimal invoiceMoney, String invoiceSubject) {
    this.id = id;
    this.order = order;
    this.invoiceDate = invoiceDate;
    this.invoiceType = invoiceType;
    this.invoiceNo = invoiceNo;
    this.invoiceMoney = invoiceMoney;
    this.invoiceSubject = invoiceSubject;
  }
}
