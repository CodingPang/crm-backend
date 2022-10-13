package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.common.R;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.service.ContactService;
import com.greatgump.crm.service.CustomerService;
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

    @ApiOperation("获取所有客户")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/customers/{current}/{size}")
    public R getAllCustomer(@PathVariable("current") int current, @PathVariable("size") int size){
        Page<Customer> customerPage = new Page<>(current,size);
        Page<Customer> pageInfo = customerService.queryAllCustomer(customerPage);

        return R.ok().put("data",pageInfo.getRecords())
                .put("count", pageInfo.getTotal());
    }
    @ApiOperation("获取我的客户")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/customers/{uid}/{current}/{size}")
    public R getCustomerByUid(@PathVariable("uid") int uid,@PathVariable("current") int current, @PathVariable("size") int size){
        Page<Customer> customerPage = new Page<>(current,size);
        Page<Customer> pageInfo = customerService.queryCustomerByUid(uid,customerPage);

        return R.ok().put("data",pageInfo.getRecords())
                .put("count", pageInfo.getTotal());
    }
    @ApiOperation("获取所有公海")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/seas/{current}/{size}")
    public R getAllSeas(@PathVariable("current") int current, @PathVariable("size") int size){
        Page<Customer> customerPage = new Page(current, size);
        Page<Customer> pageInfo = customerService.queryAllSeas(customerPage);

        return R.ok().put("data",pageInfo.getRecords())
                .put("count", pageInfo.getTotal());
    }

    @ApiOperation("添加客户")
    @PutMapping("/customer")
    public R saveCustomer(@RequestBody Customer customer){
        boolean b = customerService.saveCustomer(customer);
       return b?R.ok(): R.error();
    }
    @ApiOperation("修改客户")
    @PostMapping("/customer")
    public R editCustomer(@RequestBody Customer customer){
        boolean b = customerService.updateById(customer);
        return b?R.ok(): R.error();
    }
    @ApiOperation("删除单个客户或者公海")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "id",value ="客户的id",required = true)})
    @DeleteMapping("/customer/{id}")
    public R deleteById(@PathVariable("id") Integer id){
        boolean b = customerService.removeById(id);
        return b? R.ok(): R.error();
    }
    @ApiOperation("批量删除客户或者公海")
    @DeleteMapping("/customer")
    public R batchDelete(@RequestBody List<CustomerDto> customerDtos){
        boolean b =false;
        for (CustomerDto customerDto : customerDtos) {
            b = customerService.removeById(customerDto.getId());
        }

        return b? R.ok(): R.error();
    }
    @ApiOperation("转移客户")
    @PostMapping("/customer/transfer/{uid}")
    public R transferCustomer(@RequestBody List<CustomerDto> customerDtos,@PathVariable("uid")Integer uid){
        boolean b = false;
        for (CustomerDto customerDto : customerDtos) {
            UpdateWrapper<Customer> wrapper = new UpdateWrapper();
            wrapper.eq("id", customerDto.getId());
            wrapper.set("user_id", uid);
            b = customerService.update(wrapper);
        }
        return b? R.ok(): R.error();
    }
    @ApiOperation("移入公海")
    @PostMapping("/customer/seas")
    public R moveSeas(@RequestBody List<CustomerDto> customerDtos){
        boolean b = false;
        for (CustomerDto customerDto : customerDtos) {
            UpdateWrapper<Customer> wrapper = new UpdateWrapper();
            wrapper.eq("id", customerDto.getId());
            wrapper.set("is_customer", 0);
            b = customerService.update(wrapper);
        }
        return b? R.ok(): R.error();
    }
}
