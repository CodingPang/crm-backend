package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greatgump.crm.dto.finance.cost.CostAddDto;
import com.greatgump.crm.dto.finance.cost.CostDetailDto;
import com.greatgump.crm.dto.finance.cost.CostDto;
import com.greatgump.crm.dto.finance.cost.CostQueryDto;
import com.greatgump.crm.dto.finance.cost.CostTypeDto;
import com.greatgump.crm.dto.finance.cost.comm.CostCommFuzzyQuery;
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
   * 使用MybatisPlus查询所有的消费记录
   * @param
   * @return
   */
  Page<CostQueryDto> queryAllCost(Page<CostQueryDto> costQueryDtoPage);

  /**
   * 不使用MybatisPlus条件查询所有的消费记录
   * @param current 当前所在页
   * @param size 每页大小
   * @param costCommFuzzyQuery 条件查询对象
   * @return
   */
  List<CostQueryDto> queryAllCost(int current, int size, CostCommFuzzyQuery costCommFuzzyQuery);


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

  /**
   * 新增费用记录
   * @param costAddDto
   * @return
   */
  boolean saveCost(CostAddDto costAddDto);

  /**
   * 通过id查询费用详情
   * @param id
   * @return
   */
  CostDetailDto getOnCost(Integer id);

  /**
   * 通过主键id删除费用记录
   * @param id
   * @return
   */
  boolean deleteByPrimary(Integer id);
}