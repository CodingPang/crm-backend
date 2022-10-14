package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.BoxDto;
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
    Page<Customer> queryAllCustomer(Page page);
    Page<Customer> queryAllSeas(Page page);

    Page<Customer> queryCustomerByUid(Integer uid,Page page);

    boolean saveCustomer(Customer customer);

    BoxDto queryAllBox();

    List<LuoDto2> queryName();

    List<String> queryPhone();
}
