package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.UserDto0;
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

    List<LuoDto1> listIneed();

    List<LuoDto1> listIneed(int current, int size);

    Page<ProductDto> queryAllProducts(Page page);

    int insertProduct(AddProductDto addProductDto);

    QueryProductDto queryBid(Integer id);

    int updateProduct(UpdeProductDto updeProductDto);

    boolean deleteProduct(Integer id);

    List<ProductBox1Dto> getAssort();

    List<ProductBox2Dto> getClacUnit();

    List<ProductBox3Dto> getProperty();


    List<ProductDto> searchList(ProductsearchDto productsearchDto);
}
