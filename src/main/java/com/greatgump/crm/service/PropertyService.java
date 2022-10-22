package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.*;
import com.greatgump.crm.entity.Property;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 产品属性 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface PropertyService extends IService<Property> {
    Page<PropertyDto> queryAllPropertys(Page page);

    int insertProperty(AddPropertyDto addPropertyDto);

    QueryPropertyDto queryBid(Integer id);

    int updateProperty(UpdePropertyDto updePropertyDto);

    boolean deleteProperty(Integer id);


    List<PropertyDto> searchList1(PropertysearchDto propertysearchDto);
}
