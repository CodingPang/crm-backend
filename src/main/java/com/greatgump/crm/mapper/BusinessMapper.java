package com.greatgump.crm.mapper;

import com.greatgump.crm.dto.*;
import com.greatgump.crm.dto.finance.cost.BusinessListDto;
import com.greatgump.crm.entity.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 商机管理 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface BusinessMapper extends BaseMapper<Business> {


    /**
     * 查询出所有的商机
     * @return
     */
    List<BusinessDto> listBase(int current, int size);
    /*
    新增商机
     */
    void addBusiness(BusinessSourceDto businessSourceDto);

    /*
     * 条件查询
     */

    List<BusinessDto> queryBusinessForm(int page, int size, String customer, String businessOrigin, String businessStage, Date startDate, Date endDate);

    /*
     *
     *回显数据
     */
    List<BusinessDto2> queryId(Long id);


    /*
     * 编辑
     */
    void updateBusiness(BusinessSourceDto businessSourceDto);

    /*
     *回显跟进
     */
    @Select("select customer_name from t_customer where t_customer.id in (select customer_id from t_business where id=#{id}")
    ChasingDto queryChasing(Long id);
}
