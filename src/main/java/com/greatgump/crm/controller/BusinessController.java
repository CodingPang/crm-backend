package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.BusinessDto;
import com.greatgump.crm.dto.UserDto;
import com.greatgump.crm.entity.*;
import com.greatgump.crm.service.*;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 商机管理 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "商机模块说明")
@RestController
public class BusinessController {
    @Autowired
    private FollowFormService followFormService;
    @Autowired
    private FollowService followService;

    @ApiOperation("主页面的商机信息")
    @GetMapping("/crm/business/list")
    public Result<List<FollowForm>> list(@PathVariable("current")int current,@PathVariable("size")int size){
        Page<FollowForm> offerPage = new Page(current,size);
        Page<FollowForm> offerInfo = followFormService.page(offerPage);
        return Result.success(offerPage.getRecords(),offerInfo.getTotal());
    }
    @ApiOperation("商机线索增加")
    @PostMapping("/crm/business/add")
    public Result list(Follow follow){
        boolean flag = followService.save(follow);
        return Result.judge(flag);
    }
    @ApiOperation("主页面的单个删除")
    @DeleteMapping("/crm/business/delete")
    public Result delete(Follow follow){
        boolean flag = followService.removeById(follow);
        return Result.judge(flag);
    }

    @ApiOperation("主页面批量删除")
    @DeleteMapping("/crm/business/deletes")
    public Result deletes(List<Follow> follows){
        boolean flag = followService.removeBatchByIds(follows);
        return Result.judge(flag);
    }
    @ApiOperation("主页面修改")
    @PutMapping("/crm/business/update")
    public Result update(FollowForm followForm){
        boolean flag = followFormService.updateById(followForm);
        return Result.judge(flag);
    }



}