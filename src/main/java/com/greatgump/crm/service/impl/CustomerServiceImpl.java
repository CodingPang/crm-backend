package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.BoxDto;
import com.greatgump.crm.dto.LuoDto2;
import com.greatgump.crm.entity.*;
import com.greatgump.crm.mapper.*;
import com.greatgump.crm.service.ContactService;
import com.greatgump.crm.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.greatgump.crm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    @Autowired
    private ContactService contactService;
    @Autowired
    private ScaleMapper scaleMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private SourceMapper sourceMapper;
    @Autowired
    private IndustryMapper industryMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public BoxDto queryAllBox() {
        List<Scale> scales = scaleMapper.queryAllScale();
        List<Type> types = typeMapper.queryAllType();
        List<Source> sources = sourceMapper.queryAllSource();
        List<Industry> industries = industryMapper.queryAllIndustry();
        List<User> users = userMapper.queryAllUserName();
        BoxDto boxDto = new BoxDto(scales,types,sources,industries,users);
        return boxDto;
    }

    @Override
    public List<LuoDto2> queryName() {
          return  customerMapper.queryName();
    }

    @Override
    public List<String> queryPhone() {
        return customerMapper.queryPhone();
    }

    @Override
    public Page<Customer> queryAllCustomer(Page page) {
        return customerMapper.queryAllCustomer(page);
    }

    @Override
    public Page<Customer> queryAllSeas(Page page) {
        return customerMapper.queryAllSeas(page);
    }


    @Override
    public Page<Customer> queryCustomerByUid(Integer uid, Page page) {
        return customerMapper.queryCustomerByUid(uid, page);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean saveCustomer(Customer customer) {
        customer.setCreateTime(new Date());
        customerMapper.insertCustomer(customer);
        Contact contact = customer.getContact();
        contact.setCustomerId(customer.getId());
        boolean b = contactService.save(contact);
        return b;
    }


}
