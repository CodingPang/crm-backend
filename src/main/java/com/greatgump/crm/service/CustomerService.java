package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.BoxDto;
import com.greatgump.crm.dto.CustomerBaseDto;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.CustomerQueryDto;
import com.greatgump.crm.dto.LuoDto2;
import com.greatgump.crm.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.swing.*;
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
    Page<CustomerDto> queryAllCustomer(Page page);
    Page<CustomerDto> queryAllSeas(Page page);

    Page<CustomerDto> queryCustomerByUid(Integer uid,Page page);

    List<CustomerDto> queryCustomerDynamic(CustomerQueryDto customerQueryDto);

    List<CustomerDto> querySeasDynamic( CustomerQueryDto customerQueryDto);/**/
    boolean saveCustomer(Customer customer);

    BoxDto queryAllBox();

    CustomerBaseDto queryCustomerById(Integer cid);

    List<LuoDto2> queryName();

    List<String> queryPhone();
}
