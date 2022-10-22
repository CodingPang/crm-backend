package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.dto.back.plan.BackPlanQueryAllDto;
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
  public List<BackPlanQueryAllDto> queryAllBackPlan() {
//    backPlanMapper.queryAllBackPlan(backPlanPage);
    return null;
  }

  @Override
  public boolean deleteById(Integer id) {
    // 1、先删子表
    int resultForDetails = backPlanDetailMapper.deleteByPlanId(id);
    // 2、删主表
    int resultForPlan   = backPlanMapper.deleteById(id);

    if (resultForPlan + resultForDetails !=0 ){
      return true;
    }
    return false;
  }
}
