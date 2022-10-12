package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.common.R;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return R.ok().put("pageInfo",pageInfo);
    }
    @ApiOperation("获取所有海员")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/seas/{current}/{size}")
    public R getAllSeas(@PathVariable("current") int current, @PathVariable("size") int size){
        Page<Customer> customerPage = new Page(current, size);
        Page<Customer> pageInfo = customerService.queryAllSeas(customerPage);

        return R.ok().put("pageInfo",pageInfo);
    }
}
