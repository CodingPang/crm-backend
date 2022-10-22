package com.greatgump.crm.controller;

import com.greatgump.crm.dto.FollowDetailsDto;
import com.greatgump.crm.service.ChasingRecordService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 跟进记录表 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-15 04:12:19
 */
@RestController

@Api(tags = "售前跟进管理")
@RequestMapping("/crm/chasing-record")
public class ChasingRecordController {
    @Autowired
    private ChasingRecordService chasingRecordService;
    @PostMapping("/crm/chasing-record/all")
    @ApiOperation("售前跟进管理所有信息")
    public Result queryChasingRecordAll(){
        try{
            List<FollowDetailsDto> followDetailsDtos = this.chasingRecordService.queryChasingRecordAll();
            return Result.success(followDetailsDtos);
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("查询失败");
        }
    }

}
