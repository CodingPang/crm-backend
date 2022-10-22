package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.greatgump.crm.dto.back.plan.BackPlanQueryAllDto;
import com.greatgump.crm.entity.BackPlan;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
public interface BackPlanService extends IService<BackPlan> {

  /**
   * 获取所有的回款计划
   *  mybatisplus分页插件提供好的backplan分页对象
   * @return
   */
  List<BackPlanQueryAllDto> queryAllBackPlan();

  /**
   * 根据id删除回款计划
   * @param id
   * @return
   */
  boolean deleteById(Integer id);
}
