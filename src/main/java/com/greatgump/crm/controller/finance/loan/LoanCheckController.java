package com.greatgump.crm.controller.finance.loan;

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
    public Result deletebatch(@RequestBody List<LoanDto> loanDtos){
        boolean b =false;
        for (LoanDto loanDto : loanDtos) {
            b = loanService.removeById(loanDto.getId());
        }

        return Result.judge(b);
    }
}
