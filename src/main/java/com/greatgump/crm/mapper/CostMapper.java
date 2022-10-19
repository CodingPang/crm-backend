package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.finance.cost.CostAddDto;
import com.greatgump.crm.dto.finance.cost.CostDto;
import com.greatgump.crm.dto.finance.cost.CostQueryDto;
import com.greatgump.crm.entity.Cost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Mapper
public interface CostMapper extends BaseMapper<Cost> {

  /**
   * 查询所有的消费记录(无条件)
   * @param costDtoPage
   * @return
   */
  Page<CostQueryDto> selectAllCost(Page<CostQueryDto> costDtoPage);

  /**
   * 新增一条消费记录
   * @param costAddDto
   * @return
   */
  boolean insertOneCost(CostAddDto costAddDto);
}
