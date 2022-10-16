package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greatgump.crm.dto.finance.cost.CostDto;
import com.greatgump.crm.dto.finance.cost.CostQueryDto;
import com.greatgump.crm.entity.Cost;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
public interface CostService extends IService<Cost> {

  /**
   * 查询所有的消费记录
   * @param
   * @return
   */
  Page<CostQueryDto> queryAllCost(Page<CostQueryDto> costQueryDtoPage);
}
