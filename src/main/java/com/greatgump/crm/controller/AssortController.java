package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.*;
import com.greatgump.crm.service.AssortService;
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
 *  前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "产品分类功能说明")
@RestController
@RequestMapping("/crm/assort")
public class  AssortController {

    @Autowired
    private AssortService assortService;

    @ApiOperation("获取所有产品分类")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "page",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/queryAllAssorts/{page}/{size}")
    public Result<List<AssortDto>> queryAllLoans(@PathVariable("page") Integer current, @PathVariable("size") Integer size){

        Page<AssortDto> assortDtoPage = new Page<>(current, size);
        Page<AssortDto> pageIfo = assortService.queryAllAssorts(assortDtoPage);
        return Result.success(pageIfo.getRecords(),pageIfo.getTotal());
//        AssortDto assortDto =new AssortDto();
//
//        Assort assort = new Assort();
//        assort.setId(1L);
//        assort.setAssortName("服装");
//
//        Assort assort1 = new Assort();
//        assort1.setId(2L);
//        assort1.setAssortName("软件");
//
//        List<Assort> assortList = new ArrayList<>();
//        assortList.add(assort);
//        assortList.add(assort1);
//
//        return Result.success(assortList,4L);

    }

    @ApiOperation("产品分类增加")
    @PostMapping("/add")
    public Result preAdd(@RequestBody AddAssortDto addAssortDto){
        int assort = assortService.insertAssort(addAssortDto);
        return Result.judge(assort>0);

    }

    @ApiOperation("产品分类编辑预查询")
    @PutMapping("/querybid/{id}")
    public Result<QueryAssortDto> queryBid(@PathVariable("id") Integer id){

        return Result.success(assortService.queryBid(id));
    }

    @ApiOperation("产品分类编辑")
    @PutMapping("/updateAssort")
    public Result<UpdeAssortDto> updateAssort(@RequestBody UpdeAssortDto updeAssortDto){

        int updateAssort = assortService.updateAssort(updeAssortDto);

        if (updateAssort>0){
            return Result.success();
        }else{
            return Result.failed();
        }
    }

//    @ApiOperation("产品分类编辑")
//    @PutMapping("/update/{id}")
//    public Result<AssortDto> update(@PathVariable("id")Long id){

//        Assort assort = new Assort();
//        assort.setId(1L);
//        assort.setAssortName("服装");
//
//        AssortDto assortDto =new AssortDto();
//        assortDto.setAssort(assort);

//        return Result.success(assortDto);
//        return null;
//
//
//    }

    @ApiOperation("产品分类信息删除")
    @DeleteMapping("/deleteAssort/{id}")
    public Result deleteAssort(@PathVariable("id")Long id){

        boolean b = assortService.removeById(id);
        return Result.judge(b);


    }


//    @ApiOperation("产品分类信息批量删除")
//    @DeleteMapping("/deletion")
//    public Result deletion(@RequestBody List<AssortDto> assortDtos){
//        for (AssortDto assortDto : assortDtos) {
//            assortService.removeById(assortDto.getId());
//        }
//
//        return Result.success();
//    }

    @ApiOperation("产品分类信息批量删除")
    @DeleteMapping("/deletebatch")
    public Result deletebatch(@RequestBody List<Long> ids){

        boolean  b = assortService.removeByIds(ids);


        return Result.judge(b);
    }

}
