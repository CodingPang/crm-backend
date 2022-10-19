package com.greatgump.crm.dto;

import com.greatgump.crm.entity.Business;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Order;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditDto {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    private Long id;

    @ApiModelProperty("关联客户")
    private Customer customerId;

    @ApiModelProperty("关联订单")
    private Order orderId;

    @ApiModelProperty("关联商机")
    private Business businessId;

    @ApiModelProperty("借款金额")
    private String loanAmount;

    @ApiModelProperty("借款原因")
    private String cause;

}
