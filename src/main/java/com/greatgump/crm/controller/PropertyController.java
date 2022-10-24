package com.greatgump.crm.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.*;
import com.greatgump.crm.dto.property.PropertySearch;
import com.greatgump.crm.entity.Property;
import com.greatgump.crm.service.PropertyService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @ApiOperation("获取属性列表")
    @GetMapping("/all")
    public Result<Page<Property>> queryAll(PropertySearch propertySearch) {
        Page<Property> page = new Page<>(propertySearch.getCurrent(), propertySearch.getSize());
        QueryWrapper<Property> queryWrapper = new QueryWrapper<>();
        if (!StrUtil.isBlank(propertySearch.getSearchContent())) {
            queryWrapper.like("property_name", propertySearch.getSearchContent());
        }
        if (!StringUtils.isAnyBlank(propertySearch.getStartTime(), propertySearch.getEndTime())) {
            queryWrapper.between("creation_date", propertySearch.getStartTime(), propertySearch.getEndTime());
        }
        List<Property> properties = propertyService.getBaseMapper().selectList(queryWrapper);
        page.setRecords(properties);
        page.setTotal(properties.size());
        return Result.success(page);

    }

    @ApiOperation("新增属性")
    @PostMapping("/add")
    public Result preAdd(@RequestBody AddPropertyDto dto) {
        Property property = new Property();
        property.setId(0L);
        property.setPropertyName(dto.getPropertyName());
        property.setPropertyValue(dto.getPropertyValue());
        property.setCreationDate(new Date());
        boolean save = propertyService.save(property);
        return Result.judge(save);
    }

    @ApiOperation("根据id查询属性")
    @GetMapping("/queryById/{id}")
    public Result<Property> queryBid(@PathVariable("id") Integer id) {
        Property property = propertyService.getById(id);
        if (property != null) {
            return Result.success(property);
        }
        return Result.failed();
    }

    @ApiOperation("编辑属性")
    @PutMapping("/edit")
    public Result<UpdePropertyDto> updateProperty(@RequestBody UpdePropertyDto dto) {
        if (dto.getId() == null) {
            return Result.failed("查询失败");
        }
        Property propety = propertyService.getById(dto.getId());
        if (propety == null) {
            return Result.failed();
        }
        propety.setPropertyName(dto.getPropertyName());
        propety.setPropertyValue(dto.getPropertyValue());
        boolean update = propertyService.updateById(propety);
        if (update) {
            return Result.success();
        } else {
            return Result.failed();
        }
    }


    @ApiOperation("删除属性")
    @DeleteMapping("/del/{id}")
    public Result deleteProperty(@PathVariable("id") Integer id) {
        boolean b = propertyService.removeById(id);
        return Result.judge(b);
    }


    @ApiOperation("产品属性信息批量删除")
    @PostMapping("/del")
    public Result deletebatch(@RequestBody List<Long> ids) {

        boolean b = propertyService.removeByIds(ids);

        return Result.judge(b);
    }

}
