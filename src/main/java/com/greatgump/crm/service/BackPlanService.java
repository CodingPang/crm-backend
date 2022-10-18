package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greatgump.crm.entity.BackPlan;

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
   * @param backPlanPage mybatisplus分页插件提供好的backplan分页对象
   * @return
   */
  Page<BackPlan> queryAllBackPlan(Page backPlanPage);
}
