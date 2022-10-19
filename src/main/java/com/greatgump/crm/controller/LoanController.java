package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.*;
import com.greatgump.crm.service.LoanService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
  @GetMapping("/queryAllLoans/{current}/{size}")
  public Result<List<LoanDto>> queryAllLoans(@PathVariable("current") Integer current,@PathVariable("size") Integer size){
      Page<LoanDto> loanDtoPage = new Page<>(current,size);
      Page<LoanDto> pageInfo = loanService.queryAllLoan(loanDtoPage);
      return Result.success(pageInfo.getRecords(), pageInfo.getTotal());


  }
     @ApiOperation("借款新增")
     @PostMapping("/insertLoan")
     public Result insertLoan(@RequestBody AddedLoanDto addedLoanDto){

         int insertLoan = loanService.insertLoan(addedLoanDto);

         return Result.success(insertLoan);



     }
  @ApiOperation("获取详情")
  @GetMapping("/queryAllDetail/{id}")
  public Result<DetailDto> queryAllDetail(@PathVariable("id")Integer id) {
    DetailDto detailDto = loanService.queryAllDetail(id);

      return Result.success(detailDto);

  }
    @ApiOperation("获取编辑详情")
    @GetMapping("/queryEdit/{id}")
    public Result<EditDto> queryEdit(@PathVariable("id") Integer id) {

        return Result.success(loanService.queryEdit(id));
    }


  @ApiOperation("借款页面修改")
  @PutMapping("/updateLoan")
   public Result<AddedLoanDto> updateLoan(@RequestBody AddedLoanDto addedLoanDto){
      int updateLoan = loanService.updateLoan(addedLoanDto);
      if (updateLoan>0){
          return Result.success();
      }else {
          return Result.failed();
      }


   }
    @ApiOperation("借款页面关键词查询")
    @PostMapping("/queryAllkeys")
   public Result<LoanDto> queryAllkeys(@RequestBody List<LoanQueryDto>  loanQueryDto){

      LoanDto loanDto = new LoanDto();
      loanDto.setId(1L);
      loanDto.setCustomer(new Customer().setCustomerName("上海大华科技有限公司"));
      loanDto.setLoanAmount(BigDecimal.valueOf(2000));
      loanDto.setCause("借款原因");
      loanDto.setApprovalStatus("1");
      loanDto.setAppplicationTime(new Date(System.currentTimeMillis()));
      loanDto.setApplicant(new User().setUsername("zs"));

        return Result.success(loanDto);
   }

  @ApiOperation("借款页面删除")
  @DeleteMapping("/deleteLoan/{id}")
  public Result deleteLoan(@PathVariable("id")Long id){

      boolean b = loanService.removeById(id);
      return Result.judge(b);


  }
  @ApiOperation("借款页面批量删除")
  @DeleteMapping("/deletebatch")
  public Result deletebatch(@RequestBody List<Long> ids){
           boolean b =false;
      for (Long id : ids) {

          b = loanService.removeById(id);
      }



        return Result.judge(b);
  }
}
