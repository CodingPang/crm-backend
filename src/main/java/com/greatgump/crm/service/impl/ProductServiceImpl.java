package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.OfferListDto;
import com.greatgump.crm.dto.ProductListDto;
import com.greatgump.crm.dto.productlibrary.*;
import com.greatgump.crm.dto.LuoDto1;
import com.greatgump.crm.entity.Product;
import com.greatgump.crm.mapper.ProductMapper;
import com.greatgump.crm.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 产品库 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<LuoDto1> listIneed() {
        return productMapper.listIneed();
    }

    @Override
    public List<LuoDto1> listIneed(int customerId,int current, int size) {
        return productMapper.listIneed(customerId,current,size);
    }

    @Override
    public Page<ProductDto> queryAllProducts(Page page) {
        Page<ProductDto> productDtoPage = productMapper.queryAllProducts(page);
        return productDtoPage;
    }

    @Override
    public int insertProduct(AddProductDto addProductDto) {
        int i = productMapper.insertProduct(addProductDto);
        return i;
    }

    @Override
    public QueryProductDto queryBid(Integer id) {

        return productMapper.queryBid(id);
    }

    @Override
    public int updateProduct(UpdeProductDto updeProductDto) {
        return productMapper.updateProduct(updeProductDto);
    }

    @Override
    public List<ProductListDto> listAll() {
        return productMapper.listAll();
    }

    @Override
    public List<ProductDto> searchList(ProductsearchDto productsearchDto) {
        return productMapper.searchList(productsearchDto);
    }


}
