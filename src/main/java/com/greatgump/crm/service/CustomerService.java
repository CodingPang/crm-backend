package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

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

    boolean updateTransfer(Integer cid, Integer from,  Integer to);

    BoxDto queryAllBox();

    CustomerBaseDto queryCustomerById(Integer cid);

    List<LuoDto2> queryName();

    List<ContactNameDto> queryPhone(Long id);
}
