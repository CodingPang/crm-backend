package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.AddAssortDto;
import com.greatgump.crm.dto.productlibrary.AssortDto;
import com.greatgump.crm.dto.productlibrary.QueryAssortDto;
import com.greatgump.crm.dto.productlibrary.UpdeAssortDto;
import com.greatgump.crm.entity.Assort;
import com.greatgump.crm.mapper.AssortMapper;
import com.greatgump.crm.service.AssortService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class AssortServiceImpl extends ServiceImpl<AssortMapper, Assort> implements AssortService {
    @Autowired
    private AssortMapper assortMapper;
    @Override
    public Page<AssortDto> queryAllAssorts(Page page) {
        Page<AssortDto> assortDtoPage = assortMapper.queryAllAssorts(page);
        return assortDtoPage;
    }

    @Override
    public int insertAssort(AddAssortDto addAssortDto) {
        int assort = assortMapper.insertAssort(addAssortDto);
        return assort;
    }

    @Override
    public QueryAssortDto queryBid(Integer id) {
        return assortMapper.queryBid(id);
    }

    @Override
    public int updateAssort(UpdeAssortDto updeAssortDto) {
        return assortMapper.updateAssort(updeAssortDto);
    }

    @Override
    public boolean deleteAssort(Integer id) {
        boolean b = assortMapper.deleteAssort(id);
        return b;
    }
}
