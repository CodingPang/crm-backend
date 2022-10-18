package com.greatgump.crm.controller.finance.loan;

import com.greatgump.crm.dto.DetailDto;
import com.greatgump.crm.dto.LoanBoxDto;
import com.greatgump.crm.dto.LoanDto;
import com.greatgump.crm.entity.Business;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Loan;
import com.greatgump.crm.entity.Order;
import com.greatgump.crm.service.LoanService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
 * 借款表 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "借款审批")
@RestController
@RequestMapping("/crm/loancheck")
public class LoanCheckController {

  @Autowired
  private LoanService loanService;

  @ApiOperation("获取所有的借款信息")
  @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
  @GetMapping("/loanchecks/{current}/{size}")
  public Result<Map<String,Object>> queryAllLoans(@PathVariable("current") Integer current,@PathVariable("size") Integer size){
    LoanDto loanDto = new LoanDto();

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

    // 查询出所有的借款
    Order order01 = new Order();
    order01.setId(1L);
    order01.setOrderTitle("订单标题1");
    Order order02 = new Order();
    order02.setId(1L);
    order02.setOrderTitle("订单标题2");
    List<Order> orderList = new ArrayList<>();
    orderList.add(order01);
    orderList.add(order02);

    Business business01 = new Business();
    business01.setId(1L);
    business01.setBussinessTitle("商机标题1");
    Business business02 = new Business();
    business02.setId(1L);
    business02.setBussinessTitle("商机标题2");
    List<Business> businessList = new ArrayList<>();
    businessList.add(business01);
    businessList.add(business02);


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
    loan02.setId(1L);
    loan02.setAssociatedBusiness(customer01);
    loan02.setLoanAmount(BigDecimal.valueOf(150000)); // BigDecimal使用
    loan02.setCause("和客户沟通合同相关费用");
    loan02.setApprovalStatus(2);
    loan02.setAppplicationTime(new Date(System.currentTimeMillis())); // 利用时间戳写时间

    // 加入list
    List<Loan> loanList = new ArrayList<>();
    loanList.add(loan01);
    loanList.add(loan02);
     Map<String,Object> map = new HashMap<>();
     map.put("loanb",loanList);
    return Result.success(map,4L);
  }
 /*    @ApiOperation("借款下拉框")
     @PostMapping("/pre")
     public Result<Map<String ,Object>> preAdd(){
       LoanBoxDto loanBoxDto = new LoanBoxDto();//回显数据

       List<Customer> customerList = new ArrayList<>();//给loanDto中customerList准备数据
       Customer customer = new Customer();//给customerList准备数据
       customer.setId(1L);
       customer.setCustomerName("lss");
       customerList.add(customer);//把数据添加到customerList中
          Customer customer1 = new Customer();//给customerList准备数据
       customer1.setId(2L);
       customer1.setCustomerName("www");
       customerList.add(customer1);//把数据添加到customerList中

       List<Order> orderList = new ArrayList<>();//给loanListDto中orderList准备数据
       Order order = new Order();//给orderList准备数据
       order.setId(1L);
       order.setOrderTitle("订单标题5");
       orderList.add(order);//把数据添加到orderList中
         Order order1 = new Order();//给orderList准备数据
       order1.setId(2L);
       order1.setOrderTitle("订单标题6");
       orderList.add(order1);//把数据添加到orderList中

       List<Business> businessList = new ArrayList<>();//给loanListDto中businessList准备数据
       Business business = new Business();//给businessList准备数据
       business.setId(1L);
       business.setBussinessTitle("商机标题5");
       businessList.add(business);//把数据添加到businessList中
         Business business1 = new Business();//给businessList准备数据
       business1.setId(2L);
       business1.setBussinessTitle("商机标题6");
       businessList.add(business1);//把数据添加到businessList中



       loanBoxDto.setCustomerList(customerList);
       loanBoxDto.setOrderList(orderList);
       loanBoxDto.setBusinessList(businessList);

       Map<String, Object> map = new HashMap<>();
       map.put("loanbox",loanBoxDto);





       return Result.success(map);

     }*/
  @ApiOperation("获取详情")
  @GetMapping("/loancheck/{id}")
  public Result<Map<String,Object>> queryAllLoans(@PathVariable("id")Long id) {
    DetailDto detailDto = new DetailDto();
    detailDto.setLoanAmount(BigDecimal.valueOf(2000));
    detailDto.setSubmitted("ls");
    detailDto.setDepartment("销售二部");
    detailDto.setCustomer("上海随便集团");
    detailDto.setCause("借款原因");
    detailDto.setRelevant("附件名称.pdf");
    detailDto.setApproval_time(new Date(System.currentTimeMillis()));
    detailDto.setApprovalStatus(1);
    detailDto.setApprover("zs");
    detailDto.setSubmission_time(new Date(System.currentTimeMillis()));


    Map<String, Object> map = new HashMap<>();
    map.put("detail",detailDto);
   return Result.success(map);
  }
  @ApiOperation("借款页面修改")
  @PutMapping("/loancheck/{id}")
   public Result<LoanDto> update(@PathVariable("id")Long id){



    Customer customer = new Customer();
    customer.setId(1L);
    customer.setCustomerName("xx集团");

    Order order = new Order();
    order.setId(1L);
    order.setOrderTitle("订单标题1");

    Business business = new Business();
    business.setId(1L);
    business.setBussinessTitle("商机标题1");

    String cause = "借款原因";
    BigDecimal loanAmount = BigDecimal.valueOf(2000);

    LoanDto loanDto = new LoanDto();
    loanDto.setCustomer(customer);
    loanDto.setOrder(order);
    loanDto.setBusiness(business);
    loanDto.setCause(cause);
    loanDto.setLoanAmount(loanAmount);

    return Result.success(loanDto);

   }
//    @ApiOperation("借款页面关键词查询")
//    @GetMapping("/queryAllkeys")
//   public Result queryAllkeys(@RequestBody List<LoanQueryDto>  loanQueryDto){
//
//      LoanDto loanDto = new LoanDto();
//      loanDto.setId(1L);
//      loanDto.setCustomer(new Customer().setCustomerName("上海大华科技有限公司"));
//      loanDto.setLoanAmount(BigDecimal.valueOf(2000));
//      loanDto.setCause("借款原因");
//      loanDto.setApprovalStatus("1");
//      loanDto.setAppplicationTime(new Date(System.currentTimeMillis()));
//      loanDto.setApplicant(new User().setUsername("zs"));
//
//        return Result.success(loanDto);
//   }

/*  @ApiOperation("借款页面删除")
  @DeleteMapping("/delete/{id}")
  public Result delete(@PathVariable("id")Long id){

    loanService.removeById(id);
    return Result.success();


  }
  @ApiOperation("借款页面批量删除")
  @DeleteMapping("/deletion")
  public Result deletion(@RequestBody List<LoanDto> loanDtos){
//        System.out.println("--------------->"+loanDtos);
        for (LoanDto loanDto : loanDtos) {
            loanService.removeById(loanDto.getId());
        }

    return Result.success();
  }*/
}
