package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.*;
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
    @GetMapping("/queryAllCalcUnits/{page}/{size}")
    public Result<List<CalcUnitDto>> queryAllLoans(@PathVariable("page") Integer current, @PathVariable("size") Integer size){
        Page<CalcUnitDto> productDtoPage = new Page<>(current, size);
        Page<CalcUnitDto> pageIfo = calcUnitService.queryAllCalcUnits(productDtoPage);
        return Result.success(pageIfo.getRecords(),pageIfo.getTotal());



    }

    @ApiOperation("计量单位新增")
    @PostMapping("/add")
    public Result preAdd(@RequestBody AddCalcUnitDto addCalcUnitDto){
        int calcUnit = calcUnitService.insertCalcUnit(addCalcUnitDto);
        return Result.judge(calcUnit>0);
    }

    @ApiOperation("计量单位编辑预查询")
    @GetMapping("/querybid/{id}")
    public Result<QueryCalcUnitDto> queryBid(@PathVariable("id") Integer id){

        return Result.success(calcUnitService.queryBid(id));
    }

    @ApiOperation("计量单位编辑")
    @PutMapping("/updateAssort")
    public Result<UpdeCalcUnitDto> updateCalcUnit(@RequestBody UpdeCalcUnitDto updeCalcUnitDto){

        int updateCalcUnit = calcUnitService.updateCalcUnit(updeCalcUnitDto);

        if (updateCalcUnit>0){
            return Result.success();
        }else{
            return Result.failed();
        }
    }

    @ApiOperation("计量单位信息删除")
    @DeleteMapping("/deleteCalcUnit/{id}")
    public Result deleteCalcUnit(@PathVariable("id")Long id){

        boolean b = calcUnitService.removeById(id);
        return Result.judge(b);


    }


//    @ApiOperation("计量单位信息批量删除")
//    @DeleteMapping("/deletion")
//    public Result deletion(@RequestBody List<CalcUnitDto> calcUnitDtos){
//        for (CalcUnitDto calcUnitDto : calcUnitDtos) {
//            System.out.println("----------------->"+calcUnitDtos);
//            calcUnitService.removeById(calcUnitDto.getId());
//        }
//
//        return Result.success();
//    }

    @ApiOperation("计量单位信息批量删除")
    @DeleteMapping("/deletebatch")
    public Result deletebatch(@RequestBody List<Long> ids){

        boolean  b = calcUnitService.removeByIds(ids);


        return Result.judge(b);
    }

    @ApiOperation("计量单位搜索")
    @PostMapping("/crm/calcunit/search")
    public Result<List<CalcUnitDto>> search(@RequestBody CalcUnitsearchDto calcUnitsearchDto){
        List<CalcUnitDto> calcunitListDtoPage= calcUnitService.searchList3(calcUnitsearchDto);
//        Long count = Long.valueOf(productService.countList(productsearchDto));
        return Result.success(calcunitListDtoPage);
    }


}
