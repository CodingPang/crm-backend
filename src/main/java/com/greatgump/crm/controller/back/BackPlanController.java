package com.greatgump.crm.controller.back;

import com.greatgump.crm.dto.back.BackPlanDetailDto;
import com.greatgump.crm.dto.back.BackPlanDto;
import com.greatgump.crm.dto.back.BackPlanQueryDto;
import com.greatgump.crm.dto.back.BackRecordDto;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.OrderDto;
import com.greatgump.crm.entity.BackPlanDetail;
import com.greatgump.crm.service.BackPlanService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
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
public class  BackPlanController {

  @Autowired
  private BackPlanService backPlanService;

  @ApiOperation("获取所有回款计划信息")
  @GetMapping("/backplans/{current}/{size}")
  public Result<List<BackPlanDto>> queryAllBackPlan(@PathVariable("current") int current, @PathVariable("size") int size){
/*    Page<BackPlanDto> backPlanPage = new Page<>(current,size); // 使用MybatisPlus对单表进行分页
    Page<BackPlanDto> pageInfo = backPlanService.queryAllBackPlan(backPlanPage);

    return Result.success(
        pageInfo.getRecords(), // mybatisplus查询单表的所有记录
        pageInfo.getTotal() // 返回表中的记录总数


    );*/


   /* BackPlanDetail backPlanDetail01 = new BackPlanDetail();
    backPlanDetail01.setBackPeriods("第1期"); // 计划回款期数
    backPlanDetail01.setBackMoney(BigDecimal.valueOf(15000.68)); // 计划回款金额
    BackRecordDto backRecordDto = new BackRecordDto();
    backRecordDto.setBackMoney(BigDecimal.valueOf(15000.68)); // 实际回款金额*/

    // 回款计划1
    // 关联订单
    OrderDto orderDto01 = new OrderDto(1L,"订单1");

    // 封装计划回款期次与计划回款金额
    BackPlanDetailDto backPlanDetailDto01 = new BackPlanDetailDto("第1期", BigDecimal.valueOf(15000));
    // 封装实际回款金额
    BackRecordDto backRecordDto01 = new BackRecordDto(BigDecimal.valueOf(13000));
    // 关联客户
    CustomerDto customerDto01 = new CustomerDto();
    customerDto01.setId(1L);
    customerDto01.setCustomerName("张三");
    BackPlanDto backPlanDto01 = new BackPlanDto(1L,"xx",orderDto01,backPlanDetailDto01,backRecordDto01,2,customerDto01);

    // 回款计划2
    OrderDto orderDto02 = new OrderDto(2L,"订单2");

    // 封装计划回款期次与计划回款金额
    BackPlanDetailDto backPlanDetailDto02 = new BackPlanDetailDto("第1期", BigDecimal.valueOf(12000));
    // 封装实际回款金额
    BackRecordDto backRecordDto02 = new BackRecordDto(BigDecimal.valueOf(12000));
    // 关联客户
    CustomerDto customerDto02 = new CustomerDto();
    customerDto01.setId(1L);
    customerDto01.setCustomerName("星星科技有限公司");
    BackPlanDto backPlanDto02 = new BackPlanDto(2L,"yy",orderDto01,backPlanDetailDto01,backRecordDto01,1,customerDto02);

    List<BackPlanDto> list = new ArrayList<>();
    return Result.success(list,2L);
  }

  @ApiOperation("预新增回款计划")
  @GetMapping("/preAdd")
  public Result<BackPlanQueryDto> preAdd(){
    // 1、封装关联客户列表
    CustomerDto customerDto01 = new CustomerDto();
    customerDto01.setId(1L);
    customerDto01.setCustomerName("星辉软件开发有限公司");

    CustomerDto customerDto02 = new CustomerDto();
    customerDto02.setId(2L);
    customerDto02.setCustomerName("达克赛德网络科技有限公司");

    List<CustomerDto> customerDtos = new ArrayList<>();
    customerDtos.add(customerDto01);
    customerDtos.add(customerDto02);

    // 2、封装关联订单列表
    OrderDto orderDto01 = new OrderDto(1L,customerDto01,"订单1",BigDecimal.valueOf(15000),"2022-03-09");
    OrderDto orderDto02 = new OrderDto(2L,customerDto02,"订单1",BigDecimal.valueOf(15000),"2022-03-09");
    List<OrderDto> orderDtos = new ArrayList<>();
    orderDtos.add(orderDto01);
    orderDtos.add(orderDto02);



    BackPlanQueryDto backPlanDto = new BackPlanQueryDto(orderDtos, customerDtos); // 将需要的列表(List对象封装好的)放进BackPlanDto
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
