package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.*;
import com.greatgump.crm.mapper.*;
import com.greatgump.crm.service.ContactService;
import com.greatgump.crm.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.greatgump.crm.utils.Result;
import org.apache.ibatis.annotations.Param;
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
    private ContactMapper contactMapper;
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

    @Autowired
    private CustomertrfMapper customertrfMapper;
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
    public CustomerBaseDto queryCustomerById(Integer cid) {
        Customer customer = customerMapper.selectById(cid);
        Scale scale = scaleMapper.selectById(customer.getScaleId());
        Type type = typeMapper.selectById(customer.getTypeId());
        Source source = sourceMapper.selectById(customer.getSourceId());
        Industry industry = industryMapper.selectById(customer.getIndustryId());
        User user = userMapper.queryUserById((int) customer.getUserId());
        Contact contact = contactMapper.queryDefByCustomerIdContact(cid);
        CustomerBaseDto customerBaseDto = new CustomerBaseDto(scale,type,source,industry,user,contact);
        return customerBaseDto;
    }

    @Override
    public Page<CustomerDto> queryAllCustomer(Page page) {
        return customerMapper.queryAllCustomer(page);
    }

    @Override
    public Page<CustomerDto> queryAllSeas(Page page) {
        return customerMapper.queryAllSeas(page);
    }


    @Override
    public Page<CustomerDto> queryCustomerByUid(Integer uid, Page page) {
        return customerMapper.queryCustomerByUid(uid, page);
    }

    @Override
    public List<CustomerDto> queryCustomerDynamic(CustomerQueryDto customerQueryDto) {
        return customerMapper.queryCustomerDynamic(customerQueryDto);
    }

    @Override
    public List<CustomerDto> querySeasDynamic(CustomerQueryDto customerQueryDto) {
        return customerMapper.querySeasDynamic(customerQueryDto);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean saveCustomer(Customer customer) {
        customer.setCreateTime(new Date());
        customerMapper.insertCustomer(customer);
        Contact contact = customer.getContact();
        contact.setCustomerId(customer.getId());
        int i = contactMapper.saveContact(contact);
        return i>0?true:false;
    }

    @Override
    public boolean updateTransfer(Integer cid, Integer from, Integer to) {
        boolean u = customerMapper.transferCustomer(cid, to);
        boolean i = customertrfMapper.insertRecording(from, to);
        return u&i;
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
    public List<ContactNameDto> queryPhone(Long id) {
        return customerMapper.queryPhone(id);
    }


}
