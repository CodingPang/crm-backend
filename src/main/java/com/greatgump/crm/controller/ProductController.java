package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.AddProductDto;
import com.greatgump.crm.dto.productlibrary.ProductDto;
import com.greatgump.crm.dto.productlibrary.QueryProductDto;
import com.greatgump.crm.dto.productlibrary.UpdeProductDto;
import com.greatgump.crm.service.ProductService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/crm/product")
public class ProductController {
    @Autowired
    private ProductService productService;

@ApiOperation("获取所有产品信息")
@ApiImplicitParams(value = {@ApiImplicitParam(name = "page",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
@GetMapping("/queryAllProducts/{page}/{size}")
public Result<List<ProductDto>> queryAllProducts(@PathVariable("page") Integer current, @PathVariable("size") Integer size){
    Page<ProductDto> productDtoPage = new Page<>(current, size);
    Page<ProductDto> pageIfo = productService.queryAllProducts(productDtoPage);
    return Result.success(pageIfo.getRecords(),pageIfo.getTotal());
//    ProductDto productDto =new ProductDto();

//    Product product01 = new Product();
//    product01.setId(1L);
//    product01.setProductCode("CP-003");
//    product01.setClassification("服装");
//    product01.setProductName("男士卫衣");
//    product01.setUnit("件");
//    product01.setCreationDate(new Date());
//
//    Product product02 = new Product();
//    product02.setId(2L);
//    product02.setProductCode("CP-003");
//    product02.setClassification("服装");
//    product02.setProductName("女士卫衣");
//    product02.setUnit("件");
//    product02.setCreationDate(new Date());
//
//    List<Product> productList = new ArrayList<>();
//    productList.add(product01);
//    productList.add(product02);
//    return Result.success(productList,4L);
//
}
//
//
    @ApiOperation("产品增加")
    @PostMapping("/pre")
    public Result preAdd(@RequestBody AddProductDto addProductDto){

        int i = productService.insertProduct(addProductDto);
        return Result.judge(i>0);


        //给产品分类准备数据
//    List<Assort> assortList = new ArrayList<>();
//    Assort assort =new Assort();
//    assort.setId(1L);
//    assort.setAssortName("服装");
//    assortList.add(assort);
//
//    List<Assort> assortList1 = new ArrayList<>();
//    Assort assort1 =new Assort();
//    assort1.setId(2L);
//    assort1.setAssortName("软件");
//    assortList.add(assort1);
//
////给计量单位准备数据
//     List<CalcUnit> calcUnitList = new ArrayList<>();
//     CalcUnit calcUnit =new CalcUnit();
//     calcUnit.setId(1L);
//     calcUnit.setUnitName("件");
//     calcUnitList.add(calcUnit);
//
//     CalcUnit calcUnit1 =new CalcUnit();
//     calcUnit1.setId(2L);
//     calcUnit1.setUnitName("套");
//     calcUnitList.add(calcUnit1);
//
// //给产品属性准备数据
//     List<Property> propertyList = new ArrayList<>();
//     Property property =new Property();
//     property.setId(1L);
//     property.setPropertyName("颜色");
//     propertyList.add(property);
//
//     Property property1 =new Property();
//     property1.setId(2L);
//     property1.setPropertyName("功能");
//     propertyList.add(property1);
//
//    productBoxDto.setAssortList(assortList);
//    productBoxDto.setCalcUnitList(calcUnitList);
//    productBoxDto.setPropertyList(propertyList);

    }

    @ApiOperation("产品编辑预查询")
    @PutMapping("/querybid/{id}")
    public Result<QueryProductDto> queryBid(@PathVariable("id") Integer id){

        return Result.success(productService.queryBid(id));
    }

    @ApiOperation("产品编辑")
    @PutMapping("/updateProduct")
    public Result<UpdeProductDto> updateProduct(@RequestBody UpdeProductDto updeProductDto){

        int updateProduct = productService.updateProduct(updeProductDto);

        if (updateProduct>0){
            return Result.success();
        }else{
            return Result.failed();
        }
    }

//    String productCode = "CP-0003";
//    String productName = "男士卫衣";
//
//     Assort assort = new Assort();
//     assort.setId(1L);
//     assort.setAssortName("服装");
//
//    CalcUnit calcUnit =new CalcUnit();
//    calcUnit.setId(1L);
//    calcUnit.setUnitName("件");
//
//    Property property = new Property();
//    property.setId(1L);
//    property.setPropertyName("颜色");
//
//    ProductDto productDto =new ProductDto();
//    productDto.setProductCode(productCode);
//    productDto.setProductName(productName);
//    productDto.setAssort(assort);
//    productDto.setCalcUnit(calcUnit);
//    productDto.setProperty(property);

//    return Result.success(productDto);

    @ApiOperation("产品信息删除")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id")Long id){

        productService.removeById(id);
        return Result.success();
    }

    @ApiOperation("产品信息批量删除")
    @DeleteMapping("/deletion")
    public Result deletion(@RequestBody List<ProductDto> productDtos){
        for (ProductDto productDto : productDtos) {
             productService.removeById(productDto.getId());
        }

        return Result.success();
    }

}
