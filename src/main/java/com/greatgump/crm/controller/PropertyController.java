package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.AddPropertyDto;
import com.greatgump.crm.dto.productlibrary.PropertyDto;
import com.greatgump.crm.dto.productlibrary.QueryPropertyDto;
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
//        PropertyDto propertyDto =new PropertyDto();
//
//        Property property = new Property();
//        property.setId(1L);
//        property.setPropertyName("颜色");
//        property.setPropertyValue("红,黄");
//        property.setCreationDate(new Date());
//
//        Property property1 = new Property();
//        property1.setId(2L);
//        property1.setPropertyName("尺寸");
//        property1.setPropertyValue("XS,S,M,L,XL,XXL,XXXL");
//        property1.setCreationDate(new Date());
//
//        List<Property> propertyList = new ArrayList<>();
//        propertyList.add(property);
//        propertyList.add(property1);

//        return Result.success(propertyList,4L);

    }

    @ApiOperation("产品属性新增")
    @PostMapping ("/add")
    public Result preAdd(@RequestBody AddPropertyDto addPropertyDto){
        int property = propertyService.insertProperty(addPropertyDto);
        return Result.judge(property>0);
    }

    @ApiOperation("产品属性编辑预查询")
    @PutMapping("/querybid/{id}")
    public Result<QueryPropertyDto> queryBid(@PathVariable("id") Integer id){

        return Result.success(propertyService.queryBid(id));
    }

    @ApiOperation("产品属性编辑")
    @PutMapping("/update/{id}")
    public Result<PropertyDto> update(@PathVariable("id")Long id){

        String propertyName = "颜色";
        String propertyValue ="红,白,黑,蓝,黄";
        PropertyDto propertyDto =new PropertyDto();
        propertyDto.setPropertyName(propertyName);
        propertyDto.setPropertyValue(propertyValue);

        return Result.success(propertyDto);


    }

    @ApiOperation("产品属性信息删除")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id")Long id){
        propertyService.removeById(id);

        return Result.success();
    }

    @ApiOperation("产品属性信息批量删除")
    @DeleteMapping("/deletion")
    public Result deletion(@RequestBody List<PropertyDto> propertyDtos){
        for (PropertyDto propertyDto : propertyDtos) {
            propertyService.removeById(propertyDto.getId());
        }

        return Result.success();
    }

}
