package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.dto.finance.cost.CostDto;
import com.greatgump.crm.dto.finance.cost.CostQueryDto;
import com.greatgump.crm.entity.Cost;
import com.greatgump.crm.mapper.CostMapper;
import com.greatgump.crm.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Service
public class CostServiceImpl extends ServiceImpl<CostMapper, Cost> implements CostService {

  @Autowired
  private CostMapper costMapper;

  @Override
  public Page<CostQueryDto> queryAllCost(Page<CostQueryDto> costQueryDtoPage) {
    return costMapper.selectAllCost(costQueryDtoPage);
  }
}
