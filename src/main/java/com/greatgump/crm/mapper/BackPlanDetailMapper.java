package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greatgump.crm.entity.BackPlanDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-15 04:12:19
 */
@Mapper
public interface BackPlanDetailMapper extends BaseMapper<BackPlanDetail> {

  int deleteByPlanId(Integer id);
}
