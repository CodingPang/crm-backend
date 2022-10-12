package com.greatgump.crm.controller;

import com.greatgump.crm.common.R;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RestController
@RequestMapping("/crm")
public class CustomerController {
    @Autowired
    private CustomerService  customerService;

    @GetMapping("/customer")
    public R getAllCustomer(){
        List<Customer> customers = customerService.queryAllCustomer();

        return R.ok().put("coutomers",customers);
    }
    @GetMapping("/seas")
    public R getAllSeas(){
        List<Customer> customers = customerService.queryAllSeas();

        return R.ok().put("coutomers",customers);
    }
}
