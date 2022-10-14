package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.entity.Business;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Order;
import com.greatgump.crm.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author CodingPang
 * @version V1.0
 * @description 借款数据传输对象
 * @date 2022/10/13 10:24
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoanDto {
  private static final long serialVersionUID = 1L;

  @ApiModelProperty("主键，自增")
  private Long id;

    @ApiModelProperty("所有的用户")
   private List<Customer> customerList;

  @ApiModelProperty("所有订单")
  private List<Order> OrderList;

  @ApiModelProperty("所有商机")
  private List<Business> BusinessList;

  @ApiModelProperty("借款金额")
  private BigDecimal loanAmount;

  @ApiModelProperty("借款原因")
  private String cause;

  @ApiModelProperty("审批状态（1表示已通过，2表示待审批，0表示已驳回）")
  private String approvalStatus;

  @ApiModelProperty("申请时间")
  private Date appplicationTime;

  @ApiModelProperty("申请人员")
  private User applicant;
}
