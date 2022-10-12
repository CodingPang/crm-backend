package com.greatgump.crm.service;

import com.greatgump.crm.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 顾客表 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface CustomerService extends IService<Customer> {
    List<Customer> queryAllCustomer();
    List<Customer> queryAllSeas();
}
