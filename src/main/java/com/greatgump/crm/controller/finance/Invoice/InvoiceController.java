package com.greatgump.crm.controller.finance.Invoice;

import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.OrderDto;
import com.greatgump.crm.dto.finance.invoice.InvoiceDto;
import com.greatgump.crm.dto.finance.invoice.InvoiceQueryDto;
import com.greatgump.crm.service.InvoiceService;
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
 * 发票 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Api("发票管理")
@RestController
@RequestMapping("/crm/invoice")
public class InvoiceController {

  @Autowired
  private InvoiceService invoiceService;

  @ApiOperation("获得所有发票记录")
  @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
  @GetMapping("/invoices/{current}/{size}")
  public Result<List<InvoiceQueryDto>> queryAllCost(@PathVariable("current") int current, @PathVariable("size") int size){
  /*  Page<InvoiceQueryDto> costDtoPage = new Page<>(current,size);
    Page<InvoiceQueryDto> pageInfo = invoiceService.queryAllInvoice(costDtoPage);

    return Result.success(pageInfo.getRecords(),pageInfo.getTotal());*/
    // 关联订单
    OrderDto orderDto01 = new OrderDto(1L, null, "订单1", BigDecimal.valueOf(15000),
        "2022-03-09");
    OrderDto orderDto02 = new OrderDto(2L, null, "订单2", BigDecimal.valueOf(15000),
        "2022-03-09");

    InvoiceQueryDto invoiceQueryDto01 = new InvoiceQueryDto(1L, orderDto01, "2022-10-20", 1, 00603211,
        BigDecimal.valueOf(15000), "*现代服务*信息技术咨询服务费");
    InvoiceQueryDto invoiceQueryDto02 = new InvoiceQueryDto(2L, orderDto01, "2022-10-21", 2, 00603212,
        BigDecimal.valueOf(15000), "*现代服务*信息技术咨询服务费");

    List<InvoiceQueryDto> invoiceQueryDtos = new ArrayList<>();
    invoiceQueryDtos.add(invoiceQueryDto01);
    invoiceQueryDtos.add(invoiceQueryDto02);

    return Result.success(invoiceQueryDtos,2L);
  }

  @ApiOperation("预新增发票")
  @GetMapping("/preAdd")
  public Result<Map<String,Object>> preAdd(){

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


    // 关联订单
    OrderDto orderDto01 = new OrderDto(1L,customerDto01,"订单1", BigDecimal.valueOf(15000),"2022-03-09");
    OrderDto orderDto02 = new OrderDto(2L,customerDto02,"订单1",BigDecimal.valueOf(15000),"2022-03-09");
    List<OrderDto> orderDtos = new ArrayList<>();
    orderDtos.add(orderDto01);
    orderDtos.add(orderDto02);

    // 发票类型
    Map<Integer, String> invoiceTypes  = new HashMap<>();
    invoiceTypes.put(0, "增值税专用发票");
    invoiceTypes.put(1, "普通发票");

    // 开票科目
    Map<Integer, String> invoiceSubjects  = new HashMap<>();
    invoiceSubjects.put(0, "开票科目1");
    invoiceSubjects.put(1, "开票科目2");

    Map<String,Object> map = new HashMap<>();
    map.put("customerDtos", customerDtos);
    map.put("oders", orderDtos);
    map.put("invoiceTypes", invoiceTypes);
    map.put("invoiceSubject", invoiceSubjects);

    return Result.success(map,5L);
  }

  @ApiOperation("新增发票记录")
  @PostMapping("/invoice")
  public Result save(@RequestBody InvoiceDto invoiceDto){
    return Result.success();
  }


  @ApiOperation("删除发票记录")
  @DeleteMapping("/invoice/{id}")
  public Result deleteCost(@PathVariable("id") Integer id) {
    return Result.success();
  }
}
