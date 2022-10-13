package com.greatgump.crm.controller;

import com.greatgump.crm.common.R;
import com.greatgump.crm.dto.LoanDto;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Loan;
import com.greatgump.crm.service.LoanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 借款表 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "借款功能说明")
@RestController
@RequestMapping("/crm/loan")
public class LoanController {

  @Autowired
  private LoanService loanService;

  @ApiOperation("获取所有的借款信息")
  @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
  @GetMapping("/queryAllLoans")
  public R queryAllLoans(){
//    LoanDto loanDto = new LoanDto();

    // TODO 直接使用对应实体类封装成LoanDto成员变量
    // 1、所有用户
    Customer customer01 = new Customer();
    customer01.setId(1L);
    customer01.setCustomerName("xx集团");
   Customer customer02 = new Customer();
    customer02.setId(1L);
    customer02.setCustomerName("xx集团");

  List<Customer> customerList = new ArrayList<>();
    customerList.add(customer01);
    customerList.add(customer02);

    // TODO 还要有的成员变量 Order + Business


    // 查询出所有的借款
    // 1、条数
//    long count = loanService.count();

    // 2、借款数据
    Loan loan01 = new Loan();
    loan01.setId(1L);
    loan01.setAssociatedBusiness(customer01);
    loan01.setLoanAmount(BigDecimal.valueOf(150000)); // BigDecimal使用
    loan01.setCause("和客户沟通合同相关费用");
    loan01.setApprovalStatus(2);
    loan01.setAppplicationTime(new Date(System.currentTimeMillis())); // 利用时间戳写时间

    Loan loan02 = new Loan();
    loan02.setId(2L);
    loan02.setAssociatedBusiness(customer02);
    loan02.setLoanAmount(BigDecimal.valueOf(150000)); // BigDecimal使用
    loan02.setCause("和客户沟通合同相关费用");
    loan02.setApprovalStatus(2);
    loan02.setAppplicationTime(new Date(System.currentTimeMillis())); // 利用时间戳写时间




    // 加入list
    List<Loan> loanList = new ArrayList<>();
    loanList.add(loan01);
    loanList.add(loan02);

    return R.ok(2,loanList);
  }
}
