package com.greatgump.crm.controller.finance.order;

import com.greatgump.crm.dto.finance.reimbur.ReimburDto;
import com.greatgump.crm.dto.finance.reimbur.ReimburQueryDto;
import com.greatgump.crm.dto.power.UserDto;
import com.greatgump.crm.entity.Dept;
import com.greatgump.crm.service.OrderService;
import com.greatgump.crm.utils.Result;
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
 *  前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@RestController
@RequestMapping("/crm/ordercheck")
public class OrderCheckController {
    @Autowired 
    private OrderService orderService;

  @ApiOperation("获得所有订单记录")
  @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
  @GetMapping("/orderchecks/{current}/{size}")
  public Result<List<ReimburQueryDto>> queryAllCost(@PathVariable("current") int current, @PathVariable("size") int size){
  /*  Page<InvoiceQueryDto> costDtoPage = new Page<>(current,size);
    Page<InvoiceQueryDto> pageInfo = invoiceService.queryAllInvoice(costDtoPage);

    return Result.success(pageInfo.getRecords(),pageInfo.getTotal());*/
    // 订单部门
    Dept dept01 = new Dept(1L, "销售一部");
    Dept dept02 = new Dept(2L, "销售二部");

    // 订单人员
    UserDto user01 = new UserDto(1L, "张三");
    UserDto user02 = new UserDto(2L, "李四");

    // 封装进ReimburQueryDto
    ReimburQueryDto reimburQueryDto01 = new ReimburQueryDto(1L,"XX",dept01, BigDecimal.valueOf(300),"2022-05-13",user01,0,0);
    ReimburQueryDto reimburQueryDto02 = new ReimburQueryDto(2L,"XX",dept02,BigDecimal.valueOf(500),"2022-05-13",user02,0,0);

    List<ReimburQueryDto> reimburQueryDtos = new ArrayList<>();
    reimburQueryDtos.add(reimburQueryDto01);
    reimburQueryDtos.add(reimburQueryDto02);

    return Result.success(reimburQueryDtos,2L);
  }

  @ApiOperation("预新增订单")
  @GetMapping("/preAdd")
  public Result<Map<String,Object>> preAdd(){

    // 订单人员
    UserDto user01 = new UserDto(1L, "张三");
    UserDto user02 = new UserDto(2L, "李四");
    List<UserDto> userDtos = new ArrayList<>();
    userDtos.add(user01);
    userDtos.add(user02);

    // 订单部门
    Dept dept01 = new Dept(1L, "销售一部");
    Dept dept02 = new Dept(2L, "销售二部");
    List<Dept> depts = new ArrayList<>();
    depts.add(dept01);
    depts.add(dept02);

    // 订单类型
    Map<Integer, String> payMothods  = new HashMap<>();
    payMothods.put(0, "个人银行卡");
    payMothods.put(1, "微信");
    payMothods.put(1, "支付宝");

    Map<String, Object> preAdd  = new HashMap<>();
    preAdd.put("reimburers", userDtos);
    preAdd.put("depts", depts);
    preAdd.put("payMothods", payMothods);

    return Result.success(preAdd,3L);
  }

  @ApiOperation("新增订单记录")
  @PostMapping("/reimbur")
  public Result save(@RequestBody ReimburDto invoiceDto){
    return Result.success();
  }


  @ApiOperation("删除订单记录")
  @DeleteMapping("/reimbur/{id}")
  public Result deleteCost(@PathVariable("id") Integer id) {
    return Result.success();
  }
}
