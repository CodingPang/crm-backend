package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.User;
import io.swagger.annotations.ApiModelProperty;
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
public class LoanDto {
    @ApiModelProperty("所有的用户")
   private List<Customer> customerList;

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
