package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ProductListDto;
import com.greatgump.crm.dto.productlibrary.*;
import com.greatgump.crm.dto.LuoDto1;
import com.greatgump.crm.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 产品库 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface ProductService extends IService<Product> {
    /**
     * 获取所有产品信息
     * @return
     * @param
     */


    Page<Product> queryByPage(ProductSearch search);

    void saveProduct(AddProductDto productDto);

    Product queryById(Integer id);







    List<LuoDto1> listIneed(int customerId,int current, int size);




    QueryProductDto queryBid(Integer id);

    int updateProduct(UpdeProductDto updeProductDto);


    Page<ProductListDto> listAll(Page<ProductListDto> offerPage);

    List<ProductDto> searchList(ProductSearch productsearchDto);

}
