package com.greatgump.crm.dto.finance.cost;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.entity.Business;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Invoice;
import com.greatgump.crm.entity.Order;
import com.greatgump.crm.entity.User;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description
 * @date 2022/10/18 19:57
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CostAddDto {
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("费用编号")
  @TableField("cost_no")
  private String costNo;

  @ApiModelProperty("费用名称")
  @TableField("cost_name")
  private String costName;

  @ApiModelProperty("费用来源(0表示电话营销，1表示主动来电，2表示客户介绍，3表示展会促销，4表示其他途径)")
  @TableField("cost_source")
  private Integer costSource;

  @ApiModelProperty("费用类型(0表示招待费，1表示交通费，2表示住宿费，3表示礼品费，4表示其他)")
  @TableField("cost_type")
  private CostTypeDto costType;

  @ApiModelProperty("关联客户")
  @TableField("customer_id")
  private CustomerList customer;

  @ApiModelProperty("负责人员")
  @TableField("user_id")
  private PrincipalDto user;

  @ApiModelProperty("关联订单")
  @TableField("order_id")
  private OrderListDto order;

  @ApiModelProperty("关联商机")
  @TableField("business_id")
  private BusinessListDto business;

 /* @ApiModelProperty("关联发票(外键)")
  @TableField("invoice_id")
  private Invoice invoice;*/

  @ApiModelProperty("费用金额")
  @TableField("cost_money")
  private BigDecimal costMoney;

  @ApiModelProperty("发生时间")
  @TableField("happened_time")
  private String happenedTime;

  @ApiModelProperty("报销状态(0表示未报销，1表示已报销)")
  @TableField("expense_status")
  private Integer expenseStatus;

  @ApiModelProperty("费用描述")
  @TableField("remark")
  private String remark;
}
