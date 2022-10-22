package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.*;
import com.greatgump.crm.service.PropertyService;
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
 * 产品属性 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "产品属性功能说明")
@RestController
@RequestMapping("/crm/property")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @ApiOperation("获取所有产品属性")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "page",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/queryAllPropertys/{page}/{size}")
    public Result<List<PropertyDto>> queryAllLoans(@PathVariable("page") Integer current, @PathVariable("size") Integer size){
        Page<PropertyDto> propertyDtoPage = new Page<>(current, size);
        Page<PropertyDto> pageIfo = propertyService.queryAllPropertys(propertyDtoPage);
        return Result.success(pageIfo.getRecords(),pageIfo.getTotal());

    }

    @ApiOperation("产品属性新增")
    @PostMapping ("/add")
    public Result preAdd(@RequestBody AddPropertyDto addPropertyDto){
        int property = propertyService.insertProperty(addPropertyDto);
        return Result.judge(property>0);
    }

    @ApiOperation("产品属性编辑预查询")
    @GetMapping("/querybid/{id}")
    public Result<QueryPropertyDto> queryBid(@PathVariable("id") Integer id){

        return Result.success(propertyService.queryBid(id));
    }

    @ApiOperation("产品属性编辑")
    @PutMapping("/updateProperty")
    public Result<UpdePropertyDto> updateProperty(@RequestBody UpdePropertyDto updePropertyDto){

        int updateProperty = propertyService.updateProperty(updePropertyDto);

        if (updateProperty>0){
            return Result.success();
        }else{
            return Result.failed();
        }
    }

    @ApiOperation("产品属性信息删除")
    @DeleteMapping("/deleteProperty/{id}")
    public Result deleteProperty(@PathVariable("id")Long id){

        boolean b = propertyService.removeById(id);
        return Result.judge(b);


    }


    @ApiOperation("产品属性信息批量删除")
    @DeleteMapping("/deletebatch")
    public Result deletebatch(@RequestBody List<Long> ids){

        boolean  b = propertyService.removeByIds(ids);


        return Result.judge(b);
    }

    @ApiOperation("产品属性搜索")
    @PostMapping("/crm/property/search")
    public Result<List<PropertyDto>> search1(@RequestBody PropertysearchDto propertysearchDto){
        List<PropertyDto> productListDtoPage= propertyService.searchList1(propertysearchDto);
//        Long count = Long.valueOf(productService.countList(productsearchDto));
        return Result.success(productListDtoPage);
    }

}
