package com.greatgump.crm.controller.finance.reimbur;

import com.greatgump.crm.dto.finance.reimbur.ReimburCheckDto;
import com.greatgump.crm.dto.finance.reimbur.ReimburDto;
import com.greatgump.crm.dto.finance.reimbur.ReimburQueryDto;
import com.greatgump.crm.dto.power.UserDto;
import com.greatgump.crm.entity.Dept;
import com.greatgump.crm.service.ReimburService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
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
 * 报销 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Api("报销审批")
@RestController
@RequestMapping("/crm/reimburcheck")
public class ReimburCheckController {

  @Autowired
  private ReimburService reimburService;

  @ApiOperation("获得所有报销记录")
  @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
  @GetMapping("/reimburs/{current}/{size}")
  public Result<List<ReimburQueryDto>> queryAllCost(@PathVariable("current") int current, @PathVariable("size") int size){
  /*  Page<InvoiceQueryDto> costDtoPage = new Page<>(current,size);
    Page<InvoiceQueryDto> pageInfo = invoiceService.queryAllInvoice(costDtoPage);

    return Result.success(pageInfo.getRecords(),pageInfo.getTotal());*/
    // 报销部门
    Dept dept01 = new Dept(1L, "销售一部");
    Dept dept02 = new Dept(2L, "销售二部");

    // 报销人员
    UserDto user01 = new UserDto(1L, "张三");
    UserDto user02 = new UserDto(2L, "李四");

    // 封装进ReimburQueryDto
    ReimburQueryDto reimburQueryDto01 = new ReimburQueryDto(1L,"XX",dept01,BigDecimal.valueOf(300),"2022-05-13",user01,0,0);
    ReimburQueryDto reimburQueryDto02 = new ReimburQueryDto(2L,"XX",dept02,BigDecimal.valueOf(500),"2022-05-13",user02,0,0);

    List<ReimburQueryDto> reimburQueryDtos = new ArrayList<>();
    reimburQueryDtos.add(reimburQueryDto01);
    reimburQueryDtos.add(reimburQueryDto02);

    return Result.success(reimburQueryDtos,2L);
  }

  @ApiOperation("报销预审批")
  @GetMapping("/preEdit/{id}")
  public Result<ReimburCheckDto> preAdd(@PathVariable("id") Integer id){

    // 报销人员
    UserDto user01 = new UserDto(1L, "张三");

    // 报销部门
    Dept dept01 = new Dept(1L, "销售一部");

    // 审批人员
    UserDto checker = new UserDto(3L,"李芳芳");

    ReimburCheckDto r = new ReimburCheckDto(1L,user01,dept01,"","2022-05-23 11:31",0,checker,"","BX20200612010008");


    return Result.success(r,3L);
  }

  @ApiOperation("报销审批")
  @PutMapping("/reimburcheck")
  public Result save(@RequestBody ReimburCheckDto reimburCheckDto){
    return Result.success();
  }


}
