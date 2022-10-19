package com.greatgump.crm.controller.finance.cost;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.OrderDto;
import com.greatgump.crm.dto.finance.cost.CostAddDto;
import com.greatgump.crm.dto.finance.cost.CostDetailDto;
import com.greatgump.crm.dto.finance.cost.CostDto;
import com.greatgump.crm.dto.finance.cost.CostQueryDto;
import com.greatgump.crm.dto.finance.invoice.InvoiceDto;
import com.greatgump.crm.dto.power.UserDto;
import com.greatgump.crm.entity.Business;
import com.greatgump.crm.entity.Cost;
import com.greatgump.crm.service.CostService;
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
@Api("费用管理")
@RestController
@RequestMapping("/crm/cost")
public class CostController {

  @Autowired
  private CostService costService;

  @ApiOperation("获得所有费用记录")
  @ApiImplicitParams(value = {
      @ApiImplicitParam(name = "current", value = "当前页数", required = true),
      @ApiImplicitParam(name = "size", value = "每页的条数", required = true)})
  @GetMapping("/costs/{current}/{size}")
  public Result<List<CostQueryDto>> queryAllCost(@PathVariable("current") int current,
      @PathVariable("size") int size) {
    Page<CostQueryDto> costDtoPage = new Page<>(current, size);
    Page<CostQueryDto> pageInfo = costService.queryAllCost(costDtoPage);

    return Result.success(pageInfo.getRecords(), pageInfo.getTotal());
  }

  @ApiOperation("预新增费用")
  @GetMapping("/preAdd")
  public Result<Map<String, Object>> preAdd() {
/*    // 费用类型List
    Map<Integer, String> costTypes = new HashMap<>();
    costTypes.put(0, "招待费");
    costTypes.put(1, "交通费");
    costTypes.put(2, "住宿费");
    costTypes.put(3, "礼品费");
    costTypes.put(4, "其他");

    // 关联客户
    CustomerDto customerDto01 = new CustomerDto();
    customerDto01.setId(1L);
    customerDto01.setCustomerName("上海大华科技有限公司");

    CustomerDto customerDto02 = new CustomerDto();
    customerDto02.setId(2L);
    customerDto02.setCustomerName("苏州智慧科技有限公司");

    List<CustomerDto> customerDtos = new ArrayList<>();
    customerDtos.add(customerDto01);
    customerDtos.add(customerDto02);

    // 负责人员
    UserDto user01 = new UserDto(1L, "张三");
    UserDto user02 = new UserDto(2L, "李四");
    List<UserDto> userDtos = new ArrayList<>();
    userDtos.add(user01);
    userDtos.add(user02);

    // 关联订单
    OrderDto orderDto01 = new OrderDto(1L, customerDto01, "订单1", BigDecimal.valueOf(15000),
        "2022-03-09");
    OrderDto orderDto02 = new OrderDto(2L, customerDto02, "订单1", BigDecimal.valueOf(15000),
        "2022-03-09");
    List<OrderDto> orderDtos = new ArrayList<>();
    orderDtos.add(orderDto01);
    orderDtos.add(orderDto02);

    // 关联商机
    Business business01 = new Business(1L, "商机标题1");
    Business business02 = new Business(2L, "商机标题2");
    List<Business> businessList = new ArrayList<>();
    businessList.add(business01);
    businessList.add(business02);

    Map<String, Object> map = new HashMap<>();
    map.put("costTypes", costTypes);
    map.put("customerDtos", customerDtos);
    map.put("userDtos", userDtos);
    map.put("oders", orderDtos);
    map.put("businessList", businessList);*/

    HashMap<String, Object> map = costService.preAdd();

//    return Result.success(map, Long.valueOf(map.size()));
    return null;
  }

  @ApiOperation("新增费用记录")
  @PostMapping("/cost")
  public Result save(@RequestBody CostAddDto costAddDto) {
    // 1、非空校验
    boolean flag = false;
    if (costAddDto != null){
      /*// 2、Dto转取值存入List集合
      List<Object> list = new ArrayList<>();
      list.add(costAddDto);*/
      flag =  costService.saveCost(costAddDto);

    }
    return Result.judge(flag);
  }


  @ApiOperation("费用详情")
  @GetMapping("/cost/{id}")
  public Result<CostDetailDto> getOneCost(@PathVariable("id") Integer id) {

    CustomerDto customerDto01 = new CustomerDto();
    customerDto01.setId(1L);
    customerDto01.setCustomerName("上海大华科技有限公司");

    return Result.success(new CostDetailDto(1L,
        new InvoiceDto(1L, customerDto01, "2022-10-20", 00203321, BigDecimal.valueOf(15000),
            1)), 1L);
  }

  @ApiOperation("删除费用记录")
  @DeleteMapping("/cost/{id}")
  public Result deleteCost(@PathVariable("id") Integer id) {
    return Result.success();
  }
}
