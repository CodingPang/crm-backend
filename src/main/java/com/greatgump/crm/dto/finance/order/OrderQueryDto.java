package com.greatgump.crm.dto.finance.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.dto.CustomerDto;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 订单
 * @date 2022/10/17 3:20
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderQueryDto {
  @ApiModelProperty("自增主建")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("关联名称(外键，客户表id)")
  @TableField("customer_id")
  private CustomerDto customer;

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
  private Integer isDelete;

}
