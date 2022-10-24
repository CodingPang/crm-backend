package com.greatgump.crm.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.UpdePropertyDto;
import com.greatgump.crm.dto.unit.UnitSearch;
import com.greatgump.crm.entity.CalcUnit;
import com.greatgump.crm.service.CalcUnitService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description:计量单位功能说明
 * @Author: zhuiyi
 * @CreatTime: 2022/10/23 15:37
 **/
@Api(tags = "产品计量单位功能说明")
@RestController
@RequestMapping("/unit")
public class CalcUnitController {


    @Autowired
    private CalcUnitService calcUnitService;

    @ApiOperation("单位列表")
    @GetMapping("/all")
    public Result<Page<CalcUnit>> queryAll(UnitSearch search) {
        
        Page<CalcUnit> page = new Page<>(search.getCurrent(), search.getSize());
        QueryWrapper<CalcUnit> queryWrapper = new QueryWrapper<>();
        if (!StrUtil.isBlank(search.getUnitName())) {
            queryWrapper.like("unit_name", search.getUnitName());
        }
        List<CalcUnit> properties = calcUnitService.getBaseMapper().selectList(queryWrapper);
        page.setRecords(properties);
        page.setTotal(properties.size());
        return Result.success(page);

    }

    @ApiOperation("新增计量单位")
    @PostMapping("/add")
    public Result preAdd(String unitName) {
        CalcUnit assort = new CalcUnit();
        assort.setId(0);
        assort.setUnitName(unitName);
        assort.setCreationDate(new Date());
        return Result.judge(calcUnitService.save(assort));
    }

    @ApiOperation("根据id查询计量单位")
    @GetMapping("/queryById/{id}")
    public Result<CalcUnit> queryById(@PathVariable("id") Integer id) {
        CalcUnit assort = calcUnitService.getById(id);
        if (assort != null) {
            return Result.success(assort);
        }
        return Result.failed();
    }

    @ApiOperation("编辑计量单位")
    @PostMapping("/edit")
    public Result<UpdePropertyDto> updateProperty( Integer id,  String unitName) {
        if (id == null) {
            return Result.failed("编辑失败");
        }
        CalcUnit assort = calcUnitService.getById(id);
        if (assort == null) {
            return Result.failed();
        }
        assort.setUnitName(unitName);
        boolean update = calcUnitService.updateById(assort);
        if (update) {
            return Result.success();
        } else {
            return Result.failed();
        }
    }


    @ApiOperation("删除计量单位")
    @DeleteMapping("/del/{id}")
    public Result deleteProperty(@PathVariable("id") Integer id) {
        boolean b = calcUnitService.removeById(id);
        return Result.judge(b);
    }


    @ApiOperation("批量删除计量单位")
    @PostMapping("/del")
    public Result deletebatch(@RequestBody List<Long> ids) {

        boolean b = calcUnitService.removeByIds(ids);

        return Result.judge(b);
    }



}
