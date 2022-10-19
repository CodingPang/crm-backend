package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.AddPropertyDto;
import com.greatgump.crm.dto.productlibrary.PropertyDto;
import com.greatgump.crm.dto.productlibrary.QueryPropertyDto;
import com.greatgump.crm.entity.Property;
import com.greatgump.crm.mapper.PropertyMapper;
import com.greatgump.crm.service.PropertyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品属性 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class PropertyServiceImpl extends ServiceImpl<PropertyMapper, Property> implements PropertyService {
    @Autowired
    private PropertyMapper propertyMapper;

    @Override
    public Page<PropertyDto> queryAllPropertys(Page page) {
        Page<PropertyDto> propertyDtoPage = propertyMapper.queryAllPropertys(page);
        return propertyDtoPage;
    }

    @Override
    public int insertProperty(AddPropertyDto addPropertyDto) {
        int property = propertyMapper.insertProperty(addPropertyDto);
        return property;
    }

    @Override
    public QueryPropertyDto queryBid(Integer id) {
        return propertyMapper.queryBid(id);
    }
}
