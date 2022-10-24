package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ProductListDto;
import com.greatgump.crm.dto.productlibrary.*;
import com.greatgump.crm.dto.LuoDto1;
import com.greatgump.crm.entity.Product;
import com.greatgump.crm.entity.ProductPhoto;
import com.greatgump.crm.entity.ProductProperty;
import com.greatgump.crm.mapper.AssortMapper;
import com.greatgump.crm.mapper.ProductMapper;
import com.greatgump.crm.service.ProductPhotoService;
import com.greatgump.crm.service.ProductPropertyService;
import com.greatgump.crm.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

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

    @Autowired
    private ProductPhotoService productPhotoService;

    @Autowired
    private AssortMapper assortMapper;
    @Autowired
    private ProductPropertyService productPropertyService;

    @Override
    public Page<Product> queryByPage(ProductSearch search) {

        Page<Product> page = new Page<>(search.getCurrent(), search.getSize());

        QueryWrapper queryWrapper = new QueryWrapper();
        //排序 倒排
//        queryWrapper.orderByAsc("menber_name");

        if (!StringUtils.isBlank(search.getProductName())) {
            queryWrapper.like("product_name", search.getProductName());
        }
        if (!StringUtils.isAnyBlank(search.getStartTime(), search.getEndTime())) {
            queryWrapper.between("creation_date", search.getStartTime(), search.getEndTime());
        }
        queryWrapper.eq("p_is_delete", 0);

//        productMapper.selectByPage(page, queryWrapper);
        List<Product> list = productMapper.selectByPage(queryWrapper);
        System.out.println("去重前：--------->" + list);
        //利用set去重后 再 分页
        Set<Product> productSet = new HashSet<>(list);
        List<Product> productList = new ArrayList<>(productSet);
        System.out.println("去重后：--------->" + productList);
        page.setRecords(productList);
        page.setTotal(productList.size());

        return page;
    }

    @Override
    public void saveProduct(AddProductDto productDto) {

        Product product = new Product();
        product.setId(0);
        product.setProductCode(productDto.getProductCode());
        product.setClassificationid(productDto.getClassId());
        product.setProductName(productDto.getProductName());
        product.setUnitid(productDto.getUnitId());
        product.setCreationDate(new Date());
        product.setPrice(new BigDecimal(productDto.getPrice()));
        product.setRemark("");
        product.setIsDelete(0);
        product.setPurchasedStatus(0);
        product.setOutStatus(0);

        productMapper.insert(product);
        int productId = product.getId();
        System.out.println("自增主键是：----->" + productId);
        // 设置产品属性
        if (productId > 0 && !productDto.getPropertyIdList().isEmpty()) {
            ProductProperty productProperty = new ProductProperty();
            List<Integer> propertyIdList = productDto.getPropertyIdList();
            for (Integer propertyId : propertyIdList) {
                productProperty.setProductId(Long.valueOf(Integer.toString(productId)));
                productProperty.setPropertyId(Long.valueOf(Integer.toString(propertyId)));
                productPropertyService.save(productProperty);
            }

        }
        //存图片链接
        if (productId > 0 && !productDto.getPhotoList().isEmpty()) {
            ProductPhoto productPhoto = new ProductPhoto();
            List<String> photoList = productDto.getPhotoList();
            for (String photo : photoList) {
                productPhoto.setId(null);
                productPhoto.setProductId(productId);
                productPhoto.setProductPhoto(photo);
                productPhotoService.save(productPhoto);
            }
        }

    }

    @Override
    public Product queryById(Integer id) {

        QueryWrapper queryWrapper = new QueryWrapper();

        queryWrapper.eq("p_is_delete", 0);
        queryWrapper.eq("pid",id);
        List<Product> list = productMapper.selectByPage(queryWrapper);
        return list.get(0);
    }




    @Override
    public List<LuoDto1> listIneed(int customerId, int current, int size) {
        return productMapper.listIneed(customerId, current, size);
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
    public Page<ProductListDto> listAll(Page<ProductListDto> offerPage) {

        return productMapper.listAll(offerPage);
    }

    @Override
    public List<ProductDto> searchList(ProductSearch productsearchDto) {
        return productMapper.searchList(productsearchDto);
    }


}
