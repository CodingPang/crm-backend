package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.*;
import com.greatgump.crm.entity.Property;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 产品属性 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface PropertyMapper extends BaseMapper<Property> {
    Page<PropertyDto> queryAllPropertys(Page page);

    int insertProperty(AddPropertyDto addPropertyDto);

    QueryPropertyDto queryBid(Integer id);

    int updateProperty(UpdePropertyDto updePropertyDto);
}
