package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.dto.back.BackPlanDto;
import com.greatgump.crm.entity.BackPlan;
import com.greatgump.crm.mapper.BackPlanDetailMapper;
import com.greatgump.crm.mapper.BackPlanMapper;
import com.greatgump.crm.service.BackPlanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Service
public class BackPlanServiceImpl extends ServiceImpl<BackPlanMapper, BackPlan> implements BackPlanService {
  @Autowired
  private BackPlanMapper backPlanMapper;

  @Autowired
  private BackPlanDetailMapper backPlanDetailMapper;

  @Override
  public List<BackPlanDto> queryAllBackPlan() {
//    backPlanMapper.queryAllBackPlan(backPlanPage);
    return null;
  }
}
