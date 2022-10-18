package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    Page<CustomerDto> queryAllCustomer(Page page);
    Page<CustomerDto> queryAllSeas(Page page);
    Page<CustomerDto> queryCustomerByUid(Integer uid,Page page);
    List<CustomerDto> queryCustomerDynamic( CustomerQueryDto customerQueryDto);
    List<CustomerDto> querySeasDynamic( CustomerQueryDto customerQueryDto);
    boolean transferCustomer(@Param("cid")Integer cid,@Param("to") Integer to);
/**/
    int insertCustomer(Customer customer);


  List<LuoDto2> queryName();

    List<ContactNameDto> queryPhone(Long id);
}
