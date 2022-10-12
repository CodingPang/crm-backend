package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.mapper.CustomerMapper;
import com.greatgump.crm.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 顾客表 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Page<Customer> queryAllCustomer(Page page) {
        return customerMapper.queryAllCustomer(page);
    }

    @Override
    public Page<Customer> queryAllSeas(Page page) {
        return customerMapper.queryAllSeas(page);
    }
}
