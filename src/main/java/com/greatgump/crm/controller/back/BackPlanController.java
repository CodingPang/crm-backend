package com.greatgump.crm.controller.back;

import com.greatgump.crm.dto.back.common.BackAllFuzzyQuery;
import com.greatgump.crm.dto.back.plan.BackPlanAddDto;
import com.greatgump.crm.dto.back.plan.BackPlanDetailDto;
import com.greatgump.crm.dto.back.plan.BackPlanQueryAllDto;
import com.greatgump.crm.dto.back.plan.BackPlanQueryDto;
import com.greatgump.crm.dto.back.plan.OneBackPlanBaseDetailDto;
import com.greatgump.crm.dto.back.record.BackRecordPreDto;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.OrderDto;
import com.greatgump.crm.dto.finance.cost.CustomerList;
import com.greatgump.crm.dto.finance.cost.OrderListDto;
import com.greatgump.crm.service.BackPlanService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
  @PostMapping("/backplans/{current}/{size}")
  @ApiImplicitParams(value = {
      @ApiImplicitParam(name = "current", value = "当前页数", required = true),
      @ApiImplicitParam(name = "size", value = "每页的条数", required = true)}
  )
  public Result<List<BackPlanQueryAllDto>> queryAllBackPlan(@PathVariable("current") int current, @PathVariable("size") int size, @RequestBody
      BackAllFuzzyQuery backAllFuzzyQuery){
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
    BackPlanDetailDto backPlanDetailDto01 = new BackPlanDetailDto(2L,"第1期", BigDecimal.valueOf(15000));
    // 封装实际回款金额
    BackRecordPreDto backRecordPreDto01 = new BackRecordPreDto(BigDecimal.valueOf(13000));
    // 关联客户
    CustomerDto customerDto01 = new CustomerDto();
    customerDto01.setId(1L);
    customerDto01.setCustomerName("上海大华科技有限公司");
    BackPlanQueryAllDto backPlanQueryAllDto01 = new BackPlanQueryAllDto(1L,"xx",orderDto01,backPlanDetailDto01,
        backRecordPreDto01,2,customerDto01);

    // 回款计划2
    OrderDto orderDto02 = new OrderDto(2L,"订单2");

    // 封装计划回款期次与计划回款金额
    BackPlanDetailDto backPlanDetailDto02 = new BackPlanDetailDto(1L,"第1期", BigDecimal.valueOf(12000));
    // 封装实际回款金额
    BackRecordPreDto backRecordPreDto02 = new BackRecordPreDto(BigDecimal.valueOf(12000));
    // 关联客户
    CustomerDto customerDto02 = new CustomerDto();
    customerDto01.setId(1L);
    customerDto01.setCustomerName("星星科技有限公司");
    BackPlanQueryAllDto backPlanQueryAllDto02 = new BackPlanQueryAllDto(2L,"yy",orderDto01,backPlanDetailDto01,
        backRecordPreDto01,1,customerDto02);

    List<BackPlanQueryAllDto> list = new ArrayList<>();
    list.add(backPlanQueryAllDto01);
    list.add(backPlanQueryAllDto02);

    return Result.success(list,2L);
  }

  @ApiOperation("回款计划详情")
  @GetMapping("/backPlanDetail/{id}")
  @ApiImplicitParams(value = {
      @ApiImplicitParam(name = "id", value = "点击跳转到详情页面的对应计划的id", required = true)}
  )
  public Result<List<OneBackPlanBaseDetailDto>> getOneBackPlanDetail(@PathVariable("id") Long id){
    OneBackPlanBaseDetailDto oneBackPlanBaseDetailDto01 = new OneBackPlanBaseDetailDto(1L,"xxx",new OrderListDto(1L,"OR2022101910064452473673089314864","订单1"),"第1期",BigDecimal.valueOf(50000),BigDecimal.valueOf(40000),3,new CustomerList(1L,"上海大华科技有限公司"),"2022-10-09","2022-10-10","2022-10-09","2022-10-10",0,BigDecimal.valueOf(50000),"");

    OneBackPlanBaseDetailDto oneBackPlanBaseDetailDto02 = new OneBackPlanBaseDetailDto(2L,"xxx",new OrderListDto(1L,"OR2022101910064452473673089314864","订单1"),"第2期",BigDecimal.valueOf(50000),BigDecimal.valueOf(40000),3,new CustomerList(1L,"上海大华科技有限公司"),"2022-11-09","2022-11-11","2022-10-10","2022-11-11",0,BigDecimal.valueOf(50000),"");

    OneBackPlanBaseDetailDto oneBackPlanBaseDetailDto03 = new OneBackPlanBaseDetailDto(3L,"xxx",new OrderListDto(1L,"OR2022101910064452473673089314864","订单1"),"第3期",BigDecimal.valueOf(50000),BigDecimal.valueOf(40000),3,new CustomerList(1L,"上海大华科技有限公司"),"2022-12-09","2022-12-07","2022-11-11","2022-12-07",0,BigDecimal.valueOf(50000),"");

    List<OneBackPlanBaseDetailDto> oneBackPlanBaseDetailDtos = new ArrayList<>();
    oneBackPlanBaseDetailDtos.add(oneBackPlanBaseDetailDto01);
    oneBackPlanBaseDetailDtos.add(oneBackPlanBaseDetailDto02);
    oneBackPlanBaseDetailDtos.add(oneBackPlanBaseDetailDto03);

    return Result.success(oneBackPlanBaseDetailDtos, (long) oneBackPlanBaseDetailDtos.size());
  }

  @ApiOperation("预新增回款计划")
  @GetMapping("/preAdd")
  public Result<BackPlanQueryDto> preAdd(){
    // 1、封装关联客户列表
    CustomerList customerDto01 = new CustomerList();
    customerDto01.setId(1L);
//    customerDto01.setCustomerName("星辉软件开发有限公司");
    customerDto01.setCustomerName("上海大华科技有限公司");

    CustomerList customerDto02 = new CustomerList();
    customerDto02.setId(2L);
    customerDto02.setCustomerName("达克赛德网络科技有限公司");

    CustomerList customerDto03 = new CustomerList();
    customerDto02.setId(3L);
    customerDto02.setCustomerName("时雨听网络科技有限公司");

    List<CustomerList> customerDtos = new ArrayList<>();
    customerDtos.add(customerDto01);
    customerDtos.add(customerDto02);
    customerDtos.add(customerDto03);

    // 2、封装关联订单列表
    OrderDto orderDto01 = new OrderDto(1L,customerDto01,"订单1",BigDecimal.valueOf(15000),"2022-03-09");
    OrderDto orderDto02 = new OrderDto(2L,customerDto01,"订单2",BigDecimal.valueOf(15000),"2022-03-09");
    OrderDto orderDto03 = new OrderDto(3L,customerDto02,"订单11",BigDecimal.valueOf(15000),"2022-03-19");
    OrderDto orderDto04 = new OrderDto(4L,customerDto02,"订单12",BigDecimal.valueOf(15000),"2022-03-19");
    List<OrderDto> orderDtos = new ArrayList<>();
    orderDtos.add(orderDto01);
    orderDtos.add(orderDto02);
    orderDtos.add(orderDto03);
    orderDtos.add(orderDto04);


    BackPlanQueryDto backPlanQueryDto = new BackPlanQueryDto(orderDtos, customerDtos); // 将需要的列表(List对象封装好的)放进BackPlanQueryDto
    return Result.success(backPlanQueryDto);
  }



  @ApiOperation("新增回款计划")
  @PostMapping("/backplan")
  public Result saveBackPlan(@RequestBody BackPlanAddDto backPlanAddDto){
    return Result.success();
  }

  @ApiOperation("/预更新回款计划")
  @GetMapping("/onebackplan/{id}")
  public Result<HashMap<String,Object>> preEditBackPlan(@PathVariable("id") Integer id, @RequestBody BackPlanAddDto backPlanAddDto){
    // 1、准备关联客户列表
    CustomerList customerList01 = new CustomerList(1L, "上海大华科技有限公司");
    CustomerList customerList02 = new CustomerList(2L, "达克赛德网络科技有限公司");
    List<CustomerList> allCustomers = new ArrayList<>();
    allCustomers.add(customerList01);
    allCustomers.add(customerList02);

    // 2、关联订单
    OrderListDto orderListDto01 = new OrderListDto(1L,"OR2022101910064452473673089314864","客户购买CRM系统",customerList01,BigDecimal.valueOf(130000),"2022-10-09");
    OrderListDto orderListDto02 = new OrderListDto(2L,"OR2022101910064452473673089314865","客户购买ERP系统", customerList02,BigDecimal.valueOf(50000),"2022-10-09");
    List<OrderListDto> allOrders = new ArrayList<>();
    allOrders.add(orderListDto01);
    allOrders.add(orderListDto02);

    // 3、回款计划数据
    BackPlanAddDto backPlanAddDto01 = new BackPlanAddDto(1L,"HK202210200001",customerList01,orderListDto01,"第1期","2022-10-09",0.24,BigDecimal.valueOf(30000),"3期");
    BackPlanAddDto backPlanAddDto02 = new BackPlanAddDto(2L,"HK202210200002",customerList01,orderListDto01,"第2期","2022-11-08",0.38,BigDecimal.valueOf(30000),"3期");
    BackPlanAddDto backPlanAddDto03 = new BackPlanAddDto(3L,"HK202210200003",customerList01,orderListDto01,"第2期","2022-12-08",0.38,BigDecimal.valueOf(30000),"3期");

    List<BackPlanAddDto> allBackPlans = new ArrayList<>();
    allBackPlans.add(backPlanAddDto01);
    allBackPlans.add(backPlanAddDto02);
    allBackPlans.add(backPlanAddDto03);

    // 4、将以上查询出来的数据全部封装进HashMap
    HashMap<String,Object> map = new HashMap<>();
    map.put("allCustomers",allCustomers);
    map.put("allOrders", allOrders);
    map.put("allBackPlans", allBackPlans);

    return Result.success(map,(long)map.size());
  }

  @ApiOperation("/更新回款计划")
  @PutMapping("/backplan/{id}")
  public Result editBackPlan(@PathVariable("id") Integer id, @RequestBody BackPlanAddDto backPlanAddDto){

    return Result.success("更新成功");
  }

  @ApiOperation("/根据id删除回款计划")
  @DeleteMapping("/backplan/{id}")
  public Result deleteBackPlan(@PathVariable("id") Integer id){
    boolean result =  backPlanService.deleteById(id);
    return Result.success("删除成功");
  }

}
