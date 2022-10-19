package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.LoanDto;
import com.greatgump.crm.dto.LuoDto2;
import com.greatgump.crm.dto.OfferListDto;
import com.greatgump.crm.dto.OfferSearchDto;
import com.greatgump.crm.dto.productlibrary.*;
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

}

    @ApiOperation("产品分类下拉框")
    @GetMapping("/crm/offer_details/listAssort")
    public Result<List<ProductBox1Dto>> listAssort(){
        return Result.success(productService.getAssort());
    }

    @ApiOperation("计量单位下拉框")
    @GetMapping("/crm/Product/listCalcUnit")
    public Result<List<ProductBox2Dto>> listCalcUnit(){
        return Result.success(productService.getClacUnit());
    }

    @ApiOperation("产品属性下拉框")
    @GetMapping("/crm/Product/listProperty")
    public Result<List<ProductBox3Dto>> listProperty(){
        return Result.success(productService.getProperty());
    }




    @ApiOperation("产品增加")
    @PostMapping("/pre")
    public Result preAdd(@RequestBody AddProductDto addProductDto){

        int i = productService.insertProduct(addProductDto);
        return Result.judge(i>0);




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



    @ApiOperation("产品信息删除")
    @DeleteMapping("/deleteProduct/{id}")
    public Result deleteProduct(@PathVariable("id")Long id){

        boolean b = productService.removeById(id);
        return Result.judge(b);


    }

//    @ApiOperation("产品信息批量删除")
//    @DeleteMapping("/deletion")
//    public Result deletion(@RequestBody List<ProductDto> productDtos){
//        for (ProductDto productDto : productDtos) {
//             productService.removeById(productDto.getId());
//        }
//
//        return Result.success();
//    }

    @ApiOperation("产品信息批量删除")
    @DeleteMapping("/deletebatch")
    public Result deletebatch(@RequestBody List<Long> ids){

          boolean  b = productService.removeByIds(ids);


        return Result.judge(b);
    }

    @ApiOperation("产品管理搜索")
    @PostMapping("/crm/product/search")
    public Result<List<ProductDto>> search(@RequestBody ProductsearchDto productsearchDto){
        List<ProductDto> productListDtoPage= productService.searchList(productsearchDto);
//        Long count = Long.valueOf(productService.countList(productsearchDto));
        return Result.success(productListDtoPage);
    }



}
