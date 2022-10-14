package com.greatgump.crm.controller;

import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.OrderDto;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "订单管理说明")
@RestController
@RequestMapping("/crm/order")
public class OrderController {

  @ApiOperation("根据客户和订单查询订单总额和签单日期")
  @GetMapping("/queryOrderById/{customerdto}/{orderdto}")
  public Result<OrderDto> queryOrderByCustomerAndOrder(
      @PathVariable("customerdto") CustomerDto customerDto,
      @PathVariable("orderdto") OrderDto orderDto) {
    OrderDto orderDto1 = new OrderDto();
    orderDto1.setOderTotal(BigDecimal.valueOf(150000.00)); // 订单总额
    orderDto1.setOrderDate("2022-01-29 08:52:32");
    return Result.success(orderDto1, 1L);
  }

}
