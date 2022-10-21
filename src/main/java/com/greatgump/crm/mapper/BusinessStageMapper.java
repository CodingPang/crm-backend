package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greatgump.crm.entity.BusinessStage;
import org.apache.ibatis.annotations.Select;

public interface BusinessStageMapper extends BaseMapper<BusinessStage> {
    @Select("select * from t_business_stage where bussiness_stage=#{businessStage} ")
    BusinessStage queryByName(String businessStage);

}
