package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greatgump.crm.dto.finance.cost.CostDto;
import com.greatgump.crm.dto.finance.cost.CostQueryDto;
import com.greatgump.crm.dto.finance.cost.CostTypeDto;
import com.greatgump.crm.entity.Cost;
import java.util.HashMap;
import java.util.List;

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

  /**
   * 返回费用类型列表
   * @return
   */
  List<CostTypeDto> getAllCostType();


  /**
   *预新增费用
   * @return
   */
  HashMap<String,Object> preAdd();

}
