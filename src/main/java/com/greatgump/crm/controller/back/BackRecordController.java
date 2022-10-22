package com.greatgump.crm.controller.back;

import com.greatgump.crm.dto.back.common.BackAllFuzzyQuery;
import com.greatgump.crm.dto.back.record.BackOneRecord;
import com.greatgump.crm.dto.back.plan.BackPlanDetailDto;
import com.greatgump.crm.dto.back.plan.BackPlanQueryAllDto;
import com.greatgump.crm.dto.back.record.BackRecordAddDto;
import com.greatgump.crm.dto.back.record.BackRecordAllDto;
import com.greatgump.crm.dto.back.record.BackRecordPreDto;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.OrderDto;
import com.greatgump.crm.dto.back.common.CheckRecorderDto;
import com.greatgump.crm.dto.back.common.ReceiverDto;
import com.greatgump.crm.dto.back.common.SubmitterDto;
import com.greatgump.crm.dto.finance.cost.CustomerList;
import com.greatgump.crm.dto.finance.cost.OrderListDto;
import com.greatgump.crm.dto.finance.cost.PrincipalDto;
import com.greatgump.crm.dto.power.UserDto;
import com.greatgump.crm.entity.BackPeriod;
import com.greatgump.crm.entity.TransferType;
import com.greatgump.crm.service.BackRecordService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.shiro.crypto.hash.Hash;
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
 * 前端控制器
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
  @PostMapping("/backrecord/{current}/{size}")
  @ApiImplicitParams(value = {
      @ApiImplicitParam(name = "current", value = "当前页数", required = true),
      @ApiImplicitParam(name = "size", value = "每页的条数", required = true)

  })
  public Result<List<BackRecordAllDto>> queryAllBackPlan(@PathVariable("current") int current,
      @PathVariable("size") int size, @RequestBody(required = false) BackAllFuzzyQuery backAllFuzzyQuery) {
   /* Page<BackRecordAllDto> backRecordPage = new Page<>(current,size); // 使用MybatisPlus对单表进行分页
    Page<BackRecordAllDto> pageInfo = backRecordService.queryAllBackRecord(backRecordPage);

    return Result.success(
        pageInfo.getRecords(), // mybatisplus查询单表的所有记录
        pageInfo.getTotal() // 返回表中的记录总数

    );*/
    BackRecordAllDto backRecordAllDto01 = new BackRecordAllDto(1L, "xxxx",
        new OrderListDto(1L, "OR20221019161832123456789", "客户购买CRM系统"),
        new CustomerList(1L, "上海大华科技有限公司"),
        new BackPlanDetailDto(1L, "第1期", BigDecimal.valueOf(30000)), BigDecimal.valueOf(20000),
        "2022-8-10", 0);
    BackRecordAllDto backRecordAllDto02 = new BackRecordAllDto(2L, "xxxx",
        new OrderListDto(1L, "OR20221019161832123456789", "客户购买CRM系统"),
        new CustomerList(1L, "上海大华科技有限公司"),
        new BackPlanDetailDto(2L, "第2期", BigDecimal.valueOf(50000)), BigDecimal.valueOf(50000),
        "2022-9-10", 1);

    BackRecordAllDto backRecordAllDto03 = new BackRecordAllDto(3L, "xxxx",
        new OrderListDto(1L, "OR20221019161832123456789", "客户购买CRM系统"),
        new CustomerList(1L, "上海大华科技有限公司"),
        new BackPlanDetailDto(3L, "第3期", BigDecimal.valueOf(50000)), BigDecimal.valueOf(60000),
        "2022-9-10", 2);

    List<BackRecordAllDto> backRecordAllDtoList = new ArrayList<>();
    backRecordAllDtoList.add(backRecordAllDto01);
    backRecordAllDtoList.add(backRecordAllDto02);
    backRecordAllDtoList.add(backRecordAllDto03);

    return Result.success(backRecordAllDtoList, 3L);
  }

  @ApiOperation("回款记录详情")
  @GetMapping("/backrecord/{id}")
  public Result<BackOneRecord> queryOneBackRecord(@PathVariable("id") Long id) {
    // 准备订单信息
    OrderListDto orderListDto = new OrderListDto();
    orderListDto.setId(1L);
    orderListDto.setOrderNo("OR2022101910064452473673089314864");
    orderListDto.setOrderTitle("客户购买CRM系统");

    // 准备客户信息
    CustomerList customerList = new CustomerList(1L, "上海大华科技有限公司");

    // 准备回款期次(第1期)
    BackPlanDetailDto backPlanDetailDto01 = new BackPlanDetailDto(1L, "第1期",
        BigDecimal.valueOf(50000));
    // 准备收款人员
    // 收款人员
    ReceiverDto receiverDto = new ReceiverDto(9L, "李林");
    // 准备提交人员
    SubmitterDto submitter = new SubmitterDto(5L, "力宏");
    // 审批人员
    CheckRecorderDto checkRecorderDto = new CheckRecorderDto(6L, "赵兵");

    // 准备回款信息
    BackOneRecord oneRecord = new BackOneRecord(id, "XXX", customerList, orderListDto, "2020-06-12",
        BigDecimal.valueOf(50000), backPlanDetailDto01, 0, receiverDto, checkRecorderDto, 0, 0,
        submitter, "2020-06-12 13:56:01", "2020-06-12 13:56:12", "");

    return Result.success(oneRecord, 1L);

  }


  @ApiOperation("预新增回款记录")
  @GetMapping("/preAdd")
  public Result<BackRecordPreDto> preAdd() {
    // 1、封装关联客户列表
    CustomerDto customerDto01 = new CustomerDto();
    customerDto01.setId(1L);
    customerDto01.setCustomerName("上海大华科技有限公司");

    CustomerDto customerDto02 = new CustomerDto();
    customerDto02.setId(2L);
    customerDto02.setCustomerName("李四");

    List<CustomerDto> customerDtos = new ArrayList<>();
    customerDtos.add(customerDto01);
    customerDtos.add(customerDto02);

    // 2、封装关联订单列表
    OrderDto orderDto01 = new OrderDto(1L, "订单标题一");
    OrderDto orderDto02 = new OrderDto(2L, "订单标题二");
    List<OrderDto> orderDtos = new ArrayList<>();
    orderDtos.add(orderDto01);
    orderDtos.add(orderDto02);

    // 3、付款方式列表封装
    TransferType type01 = new TransferType(1L, "现金");
    TransferType type02 = new TransferType(2L, "对公转账");
    List<TransferType> transferTypes = new ArrayList<>();
    transferTypes.add(type01);
    transferTypes.add(type02);

    // 4、回款期次列表封装
    BackPeriod backPeriod01 = new BackPeriod(1L, "第一期");
    BackPeriod backPeriod02 = new BackPeriod(2L, "第二期");
    BackPeriod backPeriod03 = new BackPeriod(2L, "第三期");
    List<BackPeriod> backPeriods = new ArrayList<>();
    backPeriods.add(backPeriod01);
    backPeriods.add(backPeriod02);
    backPeriods.add(backPeriod03);

    // 5、收款人员列表封装
    ReceiverDto userDto01 = new ReceiverDto(1L, "张宏");
    ReceiverDto userDto02 = new ReceiverDto(2L, "张大仙");
    List<ReceiverDto> userDtos = new ArrayList<>();
    userDtos.add(userDto01);
    userDtos.add(userDto02);

    BackRecordPreDto backRecordPreDto = new BackRecordPreDto(customerDtos, orderDtos, backPeriods,
        transferTypes, userDtos); // 将需要的列表(List对象封装好的)放进BackPlanDto
    return Result.success(backRecordPreDto, 1L);
  }


  @ApiOperation("新增回款记录")
  @PostMapping("/backplan")
  public Result saveBackRecord(@RequestBody BackRecordAddDto backRecordAddDto) {

    return Result.success();
  }

  @ApiOperation("/预更新回款记录")
  @GetMapping("/backplan/{id}")
  public Result<HashMap<String,Object>> preEditBackRecord(@PathVariable("id") Integer id) {
    // 1、获取当前id对应的所有记录信息
    BackRecordAddDto backRecordAddDto = new BackRecordAddDto(new CustomerList(1L,"上海大华科技有限公司"),new OrderListDto(1L,"OR202210200001","订单1"),"2022-10-09",BigDecimal.valueOf(30000),"第1期",0,new ReceiverDto(5L,"李洪"));

    // 显示当条记录后要进行数据操作的数据
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
    OrderDto orderDto01 = new OrderDto(1L, "订单标题一");
    OrderDto orderDto02 = new OrderDto(2L, "订单标题二");
    List<OrderDto> orderDtos = new ArrayList<>();
    orderDtos.add(orderDto01);
    orderDtos.add(orderDto02);

    // 3、付款方式列表封装
    TransferType type01 = new TransferType(1L, "现金");
    TransferType type02 = new TransferType(2L, "对公转账");
    List<TransferType> transferTypes = new ArrayList<>();
    transferTypes.add(type01);
    transferTypes.add(type02);

    // 4、回款期次列表封装
    BackPeriod backPeriod01 = new BackPeriod(1L, "第一期");
    BackPeriod backPeriod02 = new BackPeriod(2L, "第二期");
    BackPeriod backPeriod03 = new BackPeriod(3L, "第三期");
    List<BackPeriod> backPeriods = new ArrayList<>();
    backPeriods.add(backPeriod01);
    backPeriods.add(backPeriod02);
    backPeriods.add(backPeriod03);

    // 5、收款人员列表封装
    ReceiverDto userDto01 = new ReceiverDto(1L, "张宏");
    ReceiverDto userDto02 = new ReceiverDto(2L, "张大仙");
    List<ReceiverDto> userDtos = new ArrayList<>();
    userDtos.add(userDto01);
    userDtos.add(userDto02);

    BackRecordPreDto backRecordPreDto = new BackRecordPreDto(customerDtos, orderDtos, backPeriods,
        transferTypes, userDtos); // 将需要的列表(List对象封装好的)放进BackPlanDto

    // 封装结果到预编辑页面
    HashMap<String,Object> map = new HashMap<>();
    map.put("oldData",backRecordAddDto);
    map.put("AllLists",backRecordPreDto);

    return Result.success(map);

  }


  @ApiOperation("/更新回款记录")
  @PutMapping("/backplan/{id}")
  public Result editBackRecord(@PathVariable("id") Integer id, @RequestBody BackRecordAddDto backRecordAddDto) {

    return Result.success("更新成功");
  }

  @ApiOperation("/根据id删除回款记录")
  @DeleteMapping("/backplan/{id}")
  public Result deleteBackRecord(@PathVariable("id") Integer id) {
     boolean result =  backRecordService.deleteByPrimaryKey(id);
    return Result.judge(result);
  }

}
