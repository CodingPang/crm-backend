package com.greatgump.crm.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.assort.AssortSearch;
import com.greatgump.crm.dto.productlibrary.*;
import com.greatgump.crm.dto.property.PropertySearch;
import com.greatgump.crm.entity.Assort;
import com.greatgump.crm.entity.Property;
import com.greatgump.crm.service.AssortService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "产品分类功能说明")
@RestController
@RequestMapping("/class")
public class AssortController {

    @Autowired
    private AssortService assortService;

    @ApiOperation("分类列表")
    @GetMapping("/all")
    public Result<Page<Assort>> queryAll( AssortSearch search) {
        Page<Assort> page = new Page<>(search.getCurrent(), search.getSize());
        QueryWrapper<Assort> queryWrapper = new QueryWrapper<>();
        if (!StrUtil.isBlank(search.getName())) {
            queryWrapper.like("assort_name", search.getName());
        }
        List<Assort> properties = assortService.getBaseMapper().selectList(queryWrapper);
        page.setRecords(properties);
        page.setTotal(properties.size());
        return Result.success(page);

    }

    @ApiOperation("新增分类")
    @PostMapping("/add")
    public Result preAdd(String className) {
        Assort assort = new Assort();
        assort.setId(0L);
        assort.setAssortName(className);
        System.out.println(assort+"-------------->111111");
        return Result.judge(assortService.save(assort));
    }

    @ApiOperation("根据id查询分类")
    @GetMapping("/queryById/{id}")
    public Result<Assort> queryById(@PathVariable("id") Integer id) {
        Assort assort = assortService.getById(id);
        if (assort != null) {
            return Result.success(assort);
        }
        return Result.failed();
    }

    @ApiOperation("编辑分类")
    @PostMapping("/edit")
    public Result<UpdePropertyDto> updateProperty(Integer id,String className) {
        if (id == null) {
            return Result.failed("编辑失败");
        }
        Assort assort = assortService.getById(id);
        if (assort == null) {
            return Result.failed();
        }
        assort.setAssortName(className);
        boolean update = assortService.updateById(assort);
        if (update) {
            return Result.success();
        } else {
            return Result.failed();
        }
    }


    @ApiOperation("删除分类")
    @DeleteMapping("/del/{id}")
    public Result deleteProperty(@PathVariable("id") Integer id) {
        boolean b = assortService.removeById(id);
        return Result.judge(b);
    }


    @ApiOperation("批量删除")
    @PostMapping("/del")
    public Result deletebatch(@RequestBody List<Long> ids) {

        boolean b = assortService.removeByIds(ids);

        return Result.judge(b);
    }

}
