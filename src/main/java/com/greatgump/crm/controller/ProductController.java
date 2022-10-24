package com.greatgump.crm.controller;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.common.collect.Lists;

import java.util.Date;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.*;
import com.greatgump.crm.entity.*;
import com.greatgump.crm.service.*;
import com.greatgump.crm.utils.NoGenerateUtils;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 产品库 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "产品库功能说明")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private AssortService assortService;

    @Autowired
    private CalcUnitService calcUnitService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private ProductPropertyService productPropertyService;

    @Autowired
    private ProductPhotoService productPhotoService;

    @ApiOperation("获取所有产品信息")
    @GetMapping("/all")
    public Result<Page<Product>> queryAllProducts(ProductSearch search) {

        return Result.success(productService.queryByPage(search));

    }

    @ApiOperation("产品分类下拉框")
    @GetMapping("/assortlist")
    public Result<List<Assort>> listAssort() {
        QueryWrapper<Assort> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("DISTINCT id,assort_name").orderByAsc("assort_name");
        return Result.success(assortService.getBaseMapper().selectList(queryWrapper));
    }

    @ApiOperation("计量单位下拉框")
    @GetMapping("/unitlist")
    public Result<List<CalcUnit>> listCalcUnit() {
        QueryWrapper<CalcUnit> wrapper = new QueryWrapper<>();
        wrapper.select("DISTINCT id,unit_name").orderByAsc("unit_name");
        List<CalcUnit> calcUnits = calcUnitService.getBaseMapper().selectList(wrapper);
        return Result.success(calcUnits);
    }

    @ApiOperation("产品属性下拉框")
    @GetMapping("/propertlist")
    public Result<List<Property>> listProperty() {
        QueryWrapper<Property> wrapper = new QueryWrapper<>();
        wrapper.select("DISTINCT id,property_name").orderByAsc("property_name");
        return Result.success(propertyService.getBaseMapper().selectList(wrapper));
    }


    @ApiOperation("产品增加")
    @PostMapping("/add")

    public Result add(@RequestBody AddProductDto productDto) {

        this.productService.saveProduct(productDto);

        return Result.success();
    }

    @ApiOperation("根据id查询")
    @PutMapping("/queryByid/{id}")
    public Result<Product> queryBid(@PathVariable("id") Integer id) {

        return Result.success(productService.queryById(id));
    }


    @ApiOperation("产品编辑")
    @PutMapping("/edit")
    public Result<UpdeProductDto> updateProduct(@RequestBody UpdeProductDto updeProductDto) {
        Integer productId = updeProductDto.getId();
        if(productId == null){
            return Result.failed();
        }

        Product product = productService.getById(productId);
        if(product == null){
            return Result.failed();
        }
        product.setId(productId);
        product.setProductCode(updeProductDto.getProductCode());
        product.setProductName(updeProductDto.getProductName());
        product.setClassificationid(updeProductDto.getClassificationid());
        product.setUnitid(updeProductDto.getUnitid());
        productService.updateById(product);
        // 设置产品属性
        if (productId > 0 && !updeProductDto.getPropertyIdList().isEmpty()) {
            //移除
            QueryWrapper<ProductProperty> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("product_id",productId);
            productPropertyService.remove(queryWrapper);
            //新增
            ProductProperty productProperty = new ProductProperty();
            List<Integer> propertyIdList = updeProductDto.getPropertyIdList();
            for (Integer propertyId : propertyIdList) {
                productProperty.setProductId(Long.valueOf(Integer.toString(productId)));
                productProperty.setPropertyId(Long.valueOf(Integer.toString(propertyId)));
                productPropertyService.save(productProperty);
            }

        }
        //存图片链接
        if (productId > 0 && !updeProductDto.getPhotoUrlList().isEmpty()) {
            //移除
            QueryWrapper<ProductPhoto> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("product_id",productId);
            productPhotoService.remove(queryWrapper);
            //新增
            ProductPhoto productPhoto = new ProductPhoto();
            List<String> photoList = updeProductDto.getPhotoUrlList();
            for (String photo : photoList) {
                productPhoto.setId(0);
                productPhoto.setProductId(productId);
                productPhoto.setProductPhoto(photo);
                productPhotoService.save(productPhoto);
            }
        }

        return Result.success();

    }


    @ApiOperation("产品信息删除")
    @DeleteMapping("/del/{id}")
    public Result deleteProduct(@PathVariable("id") Integer id) {
        boolean b = productService.removeById(id);
        return Result.judge(b);
    }


    @ApiOperation("产品信息批量删除")
    @DeleteMapping("/del")
    public Result deletebatch(@RequestBody List<Integer> idList) {

        boolean b = productService.removeByIds(idList);
        return Result.judge(b);
    }

}
