package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.BoxDto;
import com.greatgump.crm.dto.CustomerBaseDto;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.CustomerQueryDto;
import com.greatgump.crm.entity.*;
import com.greatgump.crm.service.ContactService;
import com.greatgump.crm.service.CustomerService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 顾客表 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "客户模块说明")
@RestController
@RequestMapping("/crm/customer")
public class CustomerController {
    @Autowired
    private CustomerService  customerService;

    @ApiOperation("客户查询条件查询")
    @PostMapping("/dynamic")
    public Result<List<CustomerDto>> queryCustomerDynamic(@RequestBody CustomerQueryDto customerQueryDto){
        List<CustomerDto> customerDtos1 = customerService.queryCustomerDynamic(customerQueryDto);

        return Result.success(customerDtos1);

    }
/**/
    @ApiOperation("公海查询条件查询")
    @PostMapping("/sea/dynamic")
    public Result<List<CustomerDto>> querySeasDynamic(@RequestBody CustomerQueryDto customerQueryDto){

        List<CustomerDto> customerDtos1 = customerService.querySeasDynamic(customerQueryDto);

        return Result.success(customerDtos1);

    }

    @ApiOperation("获取客户相关下拉框")
    @GetMapping("/box")
    public Result<BoxDto> queryAllBox(){

        BoxDto boxDto = customerService.queryAllBox();
        return Result.success(boxDto);
    }

    @ApiOperation("获取所有客户")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/customers/{current}/{size}")
    public Result<List<CustomerDto>> getAllCustomer(@PathVariable("current") int current, @PathVariable("size") int size){
        Page<CustomerDto> customerPage = new Page<>(current,size);
        Page<CustomerDto> pageInfo = customerService.queryAllCustomer(customerPage);

        return Result.success(pageInfo.getRecords(),pageInfo.getTotal());
    }
    @ApiOperation("获取我的客户")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "uid",value ="用户的ID",required = true),@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/customers/{uid}/{current}/{size}")
    public Result<List<CustomerDto>> getCustomerByUid(@PathVariable("uid") int uid,@PathVariable("current") int current, @PathVariable("size") int size){
        Page<CustomerDto> customerPage = new Page<>(current,size);
        Page<CustomerDto> pageInfo = customerService.queryCustomerByUid(uid,customerPage);

        return Result.success(pageInfo.getRecords(),pageInfo.getTotal());
    }
    @ApiOperation("获取所有公海")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/seas/{current}/{size}")
    public Result<List<CustomerDto>> getAllSeas(@PathVariable("current") int current, @PathVariable("size") int size){
        Page<CustomerDto> customerPage = new Page(current, size);
        Page<CustomerDto> pageInfo = customerService.queryAllSeas(customerPage);

        return Result.success(pageInfo.getRecords(),pageInfo.getTotal());
    }

    @ApiOperation("新增客户")
    @PostMapping("/customer")
    public Result saveCustomer(@RequestBody Customer customer){
        boolean b = customerService.saveCustomer(customer);
        return Result.judge(b);
    }

    @ApiOperation("修改客户或者公海--点击编辑 AND 客户名称点击进入的去的--概况信息")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "cid",value ="当前用户id",required = true)})
    @PutMapping("/customer/{cid}")
    public Result<CustomerBaseDto> preEditCustomer(@PathVariable("cid")Integer cid){
        CustomerBaseDto customerBaseDto = customerService.queryCustomerById(cid);
        return Result.success(customerBaseDto);
    }

    @ApiOperation("修改客户或者公海--点击保存")
    @PutMapping("/customer")
    public Result editCustomer(@RequestBody Customer customer){
        boolean b = customerService.updateById(customer);
        return Result.judge(b);
    }
    @ApiOperation("删除单个客户或者公海")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "id",value ="客户或者公海的id",required = true)})
    @DeleteMapping("/customer/{id}")
    public Result deleteById(@PathVariable("id") Integer id){
        boolean b = customerService.removeById(id);
        return Result.judge(b);
    }
    @ApiOperation("批量删除客户或者公海")
    @DeleteMapping("/customer")
    public Result batchDelete(@RequestBody List<CustomerDto> customerDtos){
        boolean b =false;
        for (CustomerDto customerDto : customerDtos) {
            b = customerService.removeById(customerDto.getId());
        }

        return Result.judge(b);
    }
    @ApiOperation("转移客户")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "from",value ="转出的用户(当前登录的用户)id",required = true),
                                @ApiImplicitParam(name = "to",value ="接受的用户id",required = true)
                            })
    @PutMapping("/customer/transfer/{cid}/{from}/{to}")
    public Result transferCustomer(@RequestBody List<CustomerDto> customerDtos,
                                   @PathVariable("from")Integer from,
                                   @PathVariable("to")Integer to){
        boolean b = false;
        for (CustomerDto customerDto : customerDtos) {
             b = customerService.updateTransfer((int) customerDto.getId(), from, to);
        }
        return Result.judge(b);
    }
    @ApiOperation("移入公海")
    @PutMapping("/customer/seas")
    public Result moveSeas(@RequestBody List<CustomerDto> customerDtos){
        boolean b = false;
        for (CustomerDto customerDto : customerDtos) {
            UpdateWrapper<Customer> wrapper = new UpdateWrapper();
            wrapper.eq("id", customerDto.getId());
            wrapper.set("is_customer", 0);
            b = customerService.update(wrapper);
        }
        return Result.judge(b);
    }

    @ApiOperation("领取客户")
    @PutMapping("/customer/receive/{uid}")
    public Result receiveCustomer(@PathVariable("uid")Integer uid,@RequestBody List<CustomerDto> customerDtos){
        boolean b = false;
        for (CustomerDto customerDto : customerDtos) {
            UpdateWrapper<Customer> wrapper = new UpdateWrapper();
            wrapper.eq("id", customerDto.getId());
            wrapper.set("is_customer", 1);
            wrapper.set("user_id", uid);
            b = customerService.update(wrapper);
        }
        return Result.judge(b);
    }
}
