package com.greatgump.crm.dto.finance.cost;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.User;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 订单列表 dto
 * @date 2022/10/18 17:41
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderListDto {
  @ApiModelProperty(value = "自增主建", required = true)
  private Long id;

  @ApiModelProperty("订单编号")
  private String orderNo;

  @ApiModelProperty(value = "订单标题", required = true)
  private String orderTitle;

  @ApiModelProperty("关联客户(外键，客户表id)")
  private CustomerList customer;

  @ApiModelProperty("订单归属(外键，销售id)")
  private User sale;

  @ApiModelProperty("订单总额")
  @TableField("oder_total")
  private BigDecimal oderTotal;

  @ApiModelProperty("签单日期")
  @TableField("order_date")
  private String orderDate;




  public OrderListDto(Long id, String orderNo, String orderTitle) {
    this.id = id;
    this.orderNo = orderNo;
    this.orderTitle = orderTitle;
  }


  public OrderListDto(Long id, String orderNo, String orderTitle, CustomerList customer,
      BigDecimal oderTotal) {
    this.id = id;
    this.orderNo = orderNo;
    this.orderTitle = orderTitle;
    this.customer = customer;
    this.oderTotal = oderTotal;
  }

  /**
   * 配置回款计划
   * @param id 订单id
   * @param orderNo 订单编号
   * @param orderTitle 订单标题
   * @param customer 客户
   * @param oderTotal 订单总额
   * @param orderDate 签单日期
   */
  public OrderListDto(Long id, String orderNo, String orderTitle, CustomerList customer,
      BigDecimal oderTotal, String orderDate) {
    this.id = id;
    this.orderNo = orderNo;
    this.orderTitle = orderTitle;
    this.customer = customer;
    this.oderTotal = oderTotal;
    this.orderDate = orderDate;
  }
}
