package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.CalcUnitDto;
import com.greatgump.crm.dto.PropertyDto;
import com.greatgump.crm.entity.CalcUnit;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Property;
import com.greatgump.crm.service.CalcUnitService;
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
 * 计量单位 前端控制器
 * </p>。
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "计量单位功能说明")
@RestController
@RequestMapping("/crm/calc-unit")
public class CalcUnitController {
    @Autowired
    private CalcUnitService calcUnitService;

    @ApiOperation("获取所有计量单位")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "page",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/queryAllLoans/{page}/{size}")
    public Result<Map<String,Object>> queryAllLoans(@PathVariable("page") Integer current, @PathVariable("size") Integer size){
        CalcUnitDto calcUnitDto =new CalcUnitDto();

        CalcUnit calcUnit = new CalcUnit();
        calcUnit.setId(1L);
        calcUnit.setUnitName("件");
        calcUnit.setCreationDate(new Date());

        CalcUnit calcUnit1 = new CalcUnit();
        calcUnit1.setId(2L);
        calcUnit1.setUnitName("套");
        calcUnit1.setCreationDate(new Date());

        List<CalcUnit> calcUnitList = new ArrayList<>();
        calcUnitList.add(calcUnit);
        calcUnitList.add(calcUnit1);
        Map<String,Object> map = new HashMap<>();
        map.put("calcUnit",calcUnitList);
        return Result.success(map,4L);

    }

    @ApiOperation("计量单位新增")
    @PostMapping("/add")
    public Result<Map<String ,Object>> preAdd(){

        return Result.success();
    }

    @ApiOperation("计量单位编辑")
    @PutMapping("/update/{id}")
    public Result<CalcUnitDto> update(@PathVariable("id")Long id){

        String unitName = "件";

        CalcUnitDto calcUnitDto =new CalcUnitDto();
        calcUnitDto.setUnitName(unitName);

        return Result.success(calcUnitDto);


    }


    @ApiOperation("计量单位信息删除")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id")Long id){
        calcUnitService.removeById(id);
        return Result.success();
    }

    @ApiOperation("计量单位信息批量删除")
    @DeleteMapping("/deletion")
    public Result deletion(@RequestBody List<CalcUnitDto> calcUnitDtos){
        for (CalcUnitDto calcUnitDto : calcUnitDtos) {
            System.out.println("----------------->"+calcUnitDtos);
            calcUnitService.removeById(calcUnitDto.getId());
        }

        return Result.success();
    }


}
