package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.AddCalcUnitDto;
import com.greatgump.crm.dto.productlibrary.CalcUnitDto;
import com.greatgump.crm.dto.productlibrary.QueryCalcUnitDto;
import com.greatgump.crm.entity.CalcUnit;
import com.greatgump.crm.mapper.CalcUnitMapper;
import com.greatgump.crm.service.CalcUnitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 计量单位 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class CalcUnitServiceImpl extends ServiceImpl<CalcUnitMapper, CalcUnit> implements CalcUnitService {
    @Autowired
    private CalcUnitMapper calcUnitMapper;

    @Override
    public Page<CalcUnitDto> queryAllCalcUnits(Page page) {
        Page<CalcUnitDto> calcUnitDtoPage = calcUnitMapper.queryAllCalcUnits(page);
        return calcUnitDtoPage;
    }

    @Override
    public int insertCalcUnit(AddCalcUnitDto addCalcUnitDto) {
        int calcUnit = calcUnitMapper.insertCalcUnit(addCalcUnitDto);
        return calcUnit;
    }

    @Override
    public QueryCalcUnitDto queryBid(Integer id) {
        return calcUnitMapper.queryBid(id);
    }
}
