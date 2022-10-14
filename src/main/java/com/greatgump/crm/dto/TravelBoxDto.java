package com.greatgump.crm.dto;

import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Order;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelBoxDto {

    @ApiModelProperty("所有的用户")
    private List<Customer> customerList;

    @ApiModelProperty("所有订单")
    private List<Order> OrderList;

}