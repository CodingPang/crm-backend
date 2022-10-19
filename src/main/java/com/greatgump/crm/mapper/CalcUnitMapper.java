package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.AddCalcUnitDto;
import com.greatgump.crm.dto.productlibrary.CalcUnitDto;
import com.greatgump.crm.dto.productlibrary.QueryCalcUnitDto;
import com.greatgump.crm.entity.CalcUnit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 计量单位 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface CalcUnitMapper extends BaseMapper<CalcUnit> {
    Page<CalcUnitDto> queryAllCalcUnits(Page page);

    int insertCalcUnit(AddCalcUnitDto addCalcUnitDto);

    QueryCalcUnitDto queryBid(Integer id);

}
