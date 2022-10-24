package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.entity.ProductProperty;
import com.greatgump.crm.service.ProductPropertyService;
import com.greatgump.crm.mapper.ProductPropertyMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_product_property(产品属性关联表)】的数据库操作Service实现
* @createDate 2022-10-23 10:03:31
*/
@Service
public class ProductPropertyServiceImpl extends ServiceImpl<ProductPropertyMapper, ProductProperty>
    implements ProductPropertyService{

}




