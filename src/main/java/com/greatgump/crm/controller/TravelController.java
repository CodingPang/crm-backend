package com.greatgump.crm.controller;

import com.greatgump.crm.dto.TravelBoxDto;
import com.greatgump.crm.dto.TravelDetailDto;
import com.greatgump.crm.dto.TravelDto;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Order;
import com.greatgump.crm.entity.Travel;
import com.greatgump.crm.service.TravelService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.*;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 出差表 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "出差功能说明")
@RestController
@RequestMapping("/crm/travel")
public class TravelController {

    private TravelService travelService;
    @ApiOperation("获取所有的出差信息")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/queryAllLoans/{current}/{size}")
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

        @ApiOperation("出差下拉框")
        @PutMapping("/pre")
        public Result<Map<String ,Object>> preAdd(){
            TravelBoxDto travelBoxDto = new TravelBoxDto();

            List<Customer> customerList = new ArrayList<>();//给loanDto中customerList准备数据
            Customer customer = new Customer();//给customerList准备数据
            customer.setId(1L);
            customer.setCustomerName("zss");
            customerList.add(customer);//把数据添加到customerList中

             Customer customer1 = new Customer();//给customerList准备数据
            customer1.setId(2L);
            customer1.setCustomerName("dff");
            customerList.add(customer1);//把数据添加到customerList中

            List<Order> orderList = new ArrayList<>();//给loanListDto中orderList准备数据
            Order order = new Order();//给orderList准备数据
            order.setId(1L);
            order.setOrderTitle("订单标题3");
            orderList.add(order);//把数据添加到orderList中

                Order order1 = new Order();//给orderList准备数据
            order1.setId(2L);
            order1.setOrderTitle("订单标题4");
            orderList.add(order1);//把数据添加到orderList中

            travelBoxDto.setCustomerList(customerList);
            travelBoxDto.setOrderList(orderList);

            Map<String, Object> map = new HashMap<>();
            map.put("travelb",travelBoxDto);
            return Result.success(map);


    }
    @ApiOperation("获取详情")
    @GetMapping("/queryAllTravelDetail/{id}")
    public Result<Map<String,Object>> queryAllLoans(@PathVariable("id")Long id) {
        TravelDetailDto travelDetailDto = new TravelDetailDto();
         travelDetailDto.setCustomer("上海哈哈集团");
         travelDetailDto.setRelevant("附件名称.pdf");
         travelDetailDto.setAddress("出差地址");
         travelDetailDto.setStartTime(new Date(System.currentTimeMillis()));
         travelDetailDto.setTravel_days(5);
         travelDetailDto.setEndTime(new Date(System.currentTimeMillis()));
         travelDetailDto.setCause("出差原因");
         travelDetailDto.setSubmission_time(new Date(System.currentTimeMillis()));
         travelDetailDto.setApprovalStatus(1);
         travelDetailDto.setApprover("wangwang");
         travelDetailDto.setApproval_time(new Date(System.currentTimeMillis()));

         Map<String, Object> map = new HashMap<>();
         map.put("travelDetail",travelDetailDto);
         return Result.success(map);
    }
        @ApiOperation("出差页面修改")
        @PostMapping("/update/{id}")
        public Result<TravelDto> update(@PathVariable("id")Long id){
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

            return Result.success(travelDto);

        }

    @ApiOperation("出差页面删除")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id")Long id){

        travelService.removeById(id);
        return Result.success();
    }
    @ApiOperation("出差页面批量删除")
    @DeleteMapping("/deletion")
    public Result deletion(@RequestBody List<TravelDto> travelDtos){
//        System.out.println("-------->"+travelDtos);
        for (TravelDto travelDto : travelDtos) {
            travelService.removeById(travelDto.getId());
        }

        return Result.success();
    }
}
