package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.entity.BackPlan;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Mapper
public interface BackPlanMapper extends BaseMapper<BackPlan> {

  /**
   * 查询除所有的BackPlan
   * @return
   */
  Page<BackPlan> queryAllBackPlan(Page page);
}
