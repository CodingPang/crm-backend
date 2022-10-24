package com.greatgump.crm.mapper;

import com.greatgump.crm.entity.ProductPhoto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【t_product_photo(产品图片表)】的数据库操作Mapper
* @createDate 2022-10-23 01:28:37
* @Entity com.greatgump.crm.entity.ProductPhoto
*/
public interface ProductPhotoMapper extends BaseMapper<ProductPhoto> {

    ProductPhoto selectProductPhotoByProductId(Integer productId);

}




