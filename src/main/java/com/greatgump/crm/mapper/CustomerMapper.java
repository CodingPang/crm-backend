package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 顾客表 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

    Page<Customer> queryAllCustomer(Page page);
    Page<Customer> queryAllSeas(Page page);
    Page<Customer> queryCustomerByUid(Integer uid,Page page);

    int insertCustomer(Customer customer);




}
