package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.BackPlanDto;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.OrderDto;
import com.greatgump.crm.entity.BackPlan;
import com.greatgump.crm.service.BackPlanService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Api(tags = "回款计划说明")
@RestController
@RequestMapping("/crm/backplan")
public class BackPlanController {

  @Autowired
  private BackPlanService backPlanService;

  @ApiOperation("获取所有回款计划信息")
  @GetMapping("/backplans/{current}/{size}")
  public Result<List<BackPlan>> queryAllBackPlan(@PathVariable("current") int current, @PathVariable("size") int size){
    Page<BackPlan> backPlanPage = new Page<>(current,size); // 使用MybatisPlus对单表进行分页
    Page<BackPlan> pageInfo = backPlanService.queryAllBackPlan(backPlanPage);

    return Result.success(
        pageInfo.getRecords(), // mybatisplus查询单表的所有记录
        pageInfo.getTotal() // 返回表中的记录总数


    );
  }

  @ApiOperation("预新增回款计划")
  @GetMapping("/preAdd")
  public Result<BackPlanDto> preAdd(){
    // 1、封装关联客户列表
    CustomerDto customerDto01 = new CustomerDto();
    customerDto01.setId(1L);
    customerDto01.setCustomerName("张三");

    CustomerDto customerDto02 = new CustomerDto();
    customerDto02.setId(2L);
    customerDto02.setCustomerName("李四");

    List<CustomerDto> customerDtos = new ArrayList<>();
    customerDtos.add(customerDto01);
    customerDtos.add(customerDto02);

    // 2、封装关联订单列表
    OrderDto orderDto01 = new OrderDto(1L,"订单标题一");
    OrderDto orderDto02 = new OrderDto(2L,"订单标题二");
    List<OrderDto> orderDtos = new ArrayList<>();
    orderDtos.add(orderDto01);
    orderDtos.add(orderDto02);



    BackPlanDto backPlanDto = new BackPlanDto(customerDtos,orderDtos); // 将需要的列表(List对象封装好的)放进BackPlanDto
    return Result.success(backPlanDto,2L);
  }



  @ApiOperation("新增回款计划")
  @PostMapping("/backplan")
  public Result saveBackPlan(@RequestBody BackPlanDto backPlanDto){
    return Result.success();
  }

  @ApiOperation("/更新回款计划")
  @PutMapping("/backplan/{id}")
  public Result editBackPlan(@PathVariable("id") Integer id, @RequestBody BackPlanDto backPlanDto){

    return Result.success();
  }

  @ApiOperation("/根据id删除回款计划")
  @DeleteMapping("/backplan/{id}")
  public Result deleteBackPlan(@PathVariable("id") Integer id){

    return Result.success();
  }

}
