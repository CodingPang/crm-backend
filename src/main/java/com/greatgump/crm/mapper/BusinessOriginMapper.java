package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greatgump.crm.entity.BusinessOrigin;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BusinessOriginMapper extends BaseMapper<BusinessOrigin> {
    List<BusinessOrigin> selectAll();


    @Select("select * from t_business_origin where business_origin=#{businessOrigin} ")
    BusinessOrigin queryByName(String businessOrigin);

}
