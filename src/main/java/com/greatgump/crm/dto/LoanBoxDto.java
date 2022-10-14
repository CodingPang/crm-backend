package com.greatgump.crm.dto;

import com.greatgump.crm.entity.Business;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Order;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoanBoxDto {

    @ApiModelProperty("所有的用户")
    private List<Customer> customerList;

    @ApiModelProperty("所有订单")
    private List<Order> OrderList;

    @ApiModelProperty("所有商机")
    private List<Business> BusinessList;
}