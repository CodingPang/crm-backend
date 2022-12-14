package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.dto.businessDto.ChasingDto;
import com.greatgump.crm.dto.businessDto.Customer1Dto;
import com.greatgump.crm.dto.finance.cost.CustomerList;
import com.greatgump.crm.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    List<String> queryPhone();

    List<ContactNameDto> queryPhone(Long id);

  /**
   * 不分页查询所有的Customer(只查询id与customerName)
   * @return
   */
  List<CustomerList> queryAllCustomerList();

  /*
     *商机中的关联客户
     */

    List<Customer1Dto>  selectCustomerRelation();

    /*
     *商机归属
     */

    List<Customer1Dto> selectCustomerAscription();

    /*
     *回显跟进
     */
    @Select("select customer_name from t_customer where id in (select customer_id from t_business where id=#{id})")
    ChasingDto queryChasing(@Param("id") int id);

    LuoDto2 queryId(String customerName);
}
