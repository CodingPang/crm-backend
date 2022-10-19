package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.*;
import com.greatgump.crm.entity.CalcUnit;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 计量单位 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface CalcUnitService extends IService<CalcUnit> {
    Page<CalcUnitDto> queryAllCalcUnits(Page page);

    int insertCalcUnit(AddCalcUnitDto addCalcUnitDto);

    QueryCalcUnitDto queryBid(Integer id);

    int updateCalcUnit(UpdeCalcUnitDto updeCalcUnitDto);

    boolean deleteCalcUnit(Integer id);

    List<CalcUnitDto> searchList3(CalcUnitsearchDto calcUnitsearchDto);
}
