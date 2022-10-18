package com.greatgump.crm.dto.finance.cost;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.dto.finance.invoice.InvoiceDto;
import io.swagger.annotations.ApiModelProperty;
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



/*  @ApiModelProperty("关联客户(外键)")
  @TableField("customer_id")
  private CustomerDto customer;*/


  @ApiModelProperty("关联发票(外键)")
  @TableField("invoice_id")
  private InvoiceDto invoice;

/*
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

  @ApiModelProperty("假删(0表示未删，1表示删除)")
  @TableField("is_delete")
  @TableLogic
  private Integer isDelete;
*/

}
