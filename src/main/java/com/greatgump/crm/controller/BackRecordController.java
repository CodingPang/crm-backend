package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.BackPlanDto;
import com.greatgump.crm.dto.BackRecordDto;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.OrderDto;
import com.greatgump.crm.dto.UserDto;
import com.greatgump.crm.entity.BackPeriod;
import com.greatgump.crm.entity.BackPlan;
import com.greatgump.crm.entity.BackRecord;
import com.greatgump.crm.entity.TransferType;
import com.greatgump.crm.service.BackPlanService;
import com.greatgump.crm.service.BackRecordService;
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
@Api(tags = "回款记录说明")
@RestController
@RequestMapping("/crm/backrecord")
public class BackRecordController {
  @Autowired
  private BackRecordService backRecordService;

  @ApiOperation("获取所有回款记录信息")
  @GetMapping("/backrecord/{current}/{size}")
  public Result<List<BackRecord>> queryAllBackPlan(@PathVariable("current") int current, @PathVariable("size") int size){
    Page<BackRecord> backRecordPage = new Page<>(current,size); // 使用MybatisPlus对单表进行分页
    Page<BackRecord> pageInfo = backRecordService.queryAllBackRecord(backRecordPage);

    return Result.success(
        pageInfo.getRecords(), // mybatisplus查询单表的所有记录
        pageInfo.getTotal() // 返回表中的记录总数


    );
  }

  @ApiOperation("预新增回款记录")
  @GetMapping("/preAdd")
  public Result<BackRecordDto> preAdd(){
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

    // 3、付款方式列表封装
    TransferType type01 = new TransferType(1L,"现金");
    TransferType type02 = new TransferType(2L,"对公转账");
    List<TransferType> transferTypes = new ArrayList<>();
    transferTypes.add(type01);
    transferTypes.add(type02);

    // 4、回款期次列表封装
    BackPeriod backPeriod01 = new BackPeriod(1L,"第一期");
    BackPeriod backPeriod02 = new BackPeriod(2L,"第二期");
    BackPeriod backPeriod03 = new BackPeriod(2L,"第三期");
    List<BackPeriod> backPeriods = new ArrayList<>();
    backPeriods.add(backPeriod01);
    backPeriods.add(backPeriod02);
    backPeriods.add(backPeriod03);

    // 5、收款人员列表封装
    UserDto userDto01 = new UserDto(1L,"张宏");
    UserDto userDto02 = new UserDto(2L,"张大仙");
    List<UserDto> userDtos = new ArrayList<>();
    userDtos.add(userDto01);
    userDtos.add(userDto02);


    BackRecordDto backRecordDto = new BackRecordDto(customerDtos,orderDtos,backPeriods,transferTypes,userDtos); // 将需要的列表(List对象封装好的)放进BackPlanDto
    return Result.success(backRecordDto,2L);
  }



  @ApiOperation("新增回款计划")
  @PostMapping("/backplan")
  public Result saveBackPlan(@RequestBody BackPlanDto backPlanDto){
    return Result.success();
  }

  @ApiOperation("/更新回款计划")
  @PutMapping("/backplan/{id}")
  public Result editBackPlan(@PathVariable("id") Integer id, @RequestBody BackPlanDto backPlanDto){

    return Result.success(backPlanDto);
  }

  @ApiOperation("/根据id删除回款计划")
  @DeleteMapping("/backplan/{id}")
  public Result deleteBackPlan(@PathVariable("id") Integer id){

    return Result.success();
  }

}
