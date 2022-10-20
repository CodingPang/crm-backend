package com.greatgump.crm.dto.finance.cost;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.dto.finance.cost.comm.BusinessMiniDto;
import com.greatgump.crm.dto.finance.cost.comm.InputerDto;
import com.greatgump.crm.dto.finance.cost.comm.OrderMiniDto;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 费用 详情
 * @date 2022/10/17 1:14
 * @since 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CostDetailDto {
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;


  @ApiModelProperty("费用名称")
  @TableField("cost_name")
  private String costName;

  @ApiModelProperty("费用类型(1表示招待费，2表示交通费，3表示住宿费，4表示礼品费，5表示其他)")
  @TableField("cost_type")
  private Integer costType;


  @ApiModelProperty("关联客户(外键)")
  @TableField("customer_id")
  private CustomerList customer;

  @ApiModelProperty("负责人员(外键，销售)")
  @TableField("user_id")
  private PrincipalDto user;

  @ApiModelProperty("关联订单(外键)")
  @TableField("order_id")
  private OrderMiniDto order;

  @ApiModelProperty("关联商机(外键)")
  @TableField("business_id")
  private BusinessMiniDto business;

/*  @ApiModelProperty("关联发票(外键)")
  @TableField("invoice_id")
  private InvoiceMiniDto invoice;*/

  @ApiModelProperty("费用金额")
  @TableField("cost_money")
  private BigDecimal costMoney;

  @ApiModelProperty("发生时间")
  @TableField("happened_time")
  private String happenedTime;

  @ApiModelProperty("费用描述")
  @TableField("remark")
  private String remark;

  @ApiModelProperty("录入人员(外键，会计)")
  @TableField("inputer_id")
  private InputerDto inputer;

  @ApiModelProperty("报销状态(1表示未报销，2表示已报销)")
  @TableField("expense_status")
  private Integer expenseStatus;

  @ApiModelProperty("创建时间")
  @TableField("creation_time")
  private String creationTime;

}
