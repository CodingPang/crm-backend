package com.greatgump.crm.controller.finance.travel;

import com.greatgump.crm.dto.TravelDto;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Order;
import com.greatgump.crm.entity.Travel;
import com.greatgump.crm.service.TravelService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
@RestController
@RequestMapping("/crm/travelcheck")
public class TravelCheckController {
  private TravelService travelService;
  @ApiOperation("获取所有的出差信息")
  @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
  @GetMapping("/travelchecks/{current}/{size}")
  public Result<Map<String,Object>> queryAllLoans(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
    TravelDto travelDto = new TravelDto();
    Customer customer03 = new Customer();
    customer03.setId(1L);
    customer03.setCustomerName("xx集团");
    Customer customer04 = new Customer();
    customer04.setId(1L);
    customer04.setCustomerName("xx集团");

    List<Customer> customerList = new ArrayList<>();
    customerList.add(customer03);
    customerList.add(customer04);

    // 查询出所有的借款
    Order order01 = new Order();
    order01.setId(1L);
    order01.setOrderTitle("订单标题1");
    Order order02 = new Order();
    order02.setId(1L);
    order02.setOrderTitle("订单标题2");
    List<Order> orderList = new ArrayList<>();
    orderList.add(order01);
    orderList.add(order02);

    Travel travel01 = new Travel();
    travel01.setId(1L);
    travel01.setApplicant("zs");
    travel01.setCause("出差原因");
    travel01.setStartTime(new Date(System.currentTimeMillis()));
    travel01.setEndTime(new Date(System.currentTimeMillis()));
    travel01.setTravelDays(4);
    travel01.setApprovalStatus(1);
    Travel travel02 = new Travel();
    travel02.setId(2L);
    travel02.setApplicant("ls");
    travel02.setCause("出差原因");
    travel02.setStartTime(new Date(System.currentTimeMillis()));
    travel02.setEndTime(new Date(System.currentTimeMillis()));
    travel02.setTravelDays(5);
    travel02.setApprovalStatus(2);

    List<Travel> travelList = new ArrayList<>();
    travelList.add(travel01);
    travelList.add(travel02);
    Map<String, Object> map = new HashMap<>();
    map.put("travel", travelList);

    return Result.success(map, 4L);
  }

  @ApiOperation("出差审批")
  @PutMapping("/travelcheck/{id}")
  public Result<TravelDto> update(@PathVariable("id") Integer id){
    Customer customer = new Customer();
    customer.setId(1L);
    customer.setCustomerName("xx集团");

    Order order = new Order();
    order.setId(1L);
    order.setOrderTitle("订单标题1");

    String cause = "出差原因";

    TravelDto travelDto = new TravelDto();
    travelDto.setCustomer(customer);
    travelDto.setOrder(order);
    travelDto.setCause(cause);

    return Result.success();

  }

}
