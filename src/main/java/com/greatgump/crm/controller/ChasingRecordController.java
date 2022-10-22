package com.greatgump.crm.controller;

import com.greatgump.crm.dto.chasing.ChasingMethodDto;
import com.greatgump.crm.dto.chasing.ChasingRecordDto;
import com.greatgump.crm.dto.clue.ClueCustomerDto;
import com.greatgump.crm.dto.clue.ClueUser;
import com.greatgump.crm.entity.ChasingRecord;
import com.greatgump.crm.mapper.ClueReceiveDtoMapper;
import com.greatgump.crm.service.ChasingRecordService;
import com.greatgump.crm.service.ClueService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 跟进记录表 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-15 04:12:19
 */
@Api(tags = "跟进管理模块说明")
@RestController
@RequestMapping("/crm/chasing-record")
public class ChasingRecordController {

    @Autowired
    private ChasingRecordService chasingRecordService;

    @Autowired
    private ClueService clueService;

    @ApiOperation("跟进管理")
    @GetMapping("/chasingRecord")
    public Result queryAllChasingRecord() {

        List<ChasingRecordDto> chasingMethodDtos = this.chasingRecordService.queryAllChasingRecords();

        Map map = new HashMap();
        map.put("chasingMethodDtos",chasingMethodDtos);
        return Result.success(map);

    }

    @ApiOperation("跟进管理添加")
    @GetMapping("/addChasingRecord")
    public Result addChasingRecord(@RequestBody ChasingRecord chasingRecord) {
        List<ChasingMethodDto> chasingMethodDtos = this.chasingRecordService.queryAllChasingMethod();
        List<ClueUser> clueUsers = this.clueService.queryAllClueUser();
        List<ClueCustomerDto> clueCustomerDtos = this.chasingRecordService.queryAllCustomer();
//        List<ClueCustomerDto> clueCustomerDtos = this.clueService.queryAllClueCustomerDto();

        this.chasingRecordService.addChasingRecordByCustomerId(chasingRecord);

//        this.chasingRecordService.addChasingRecord(chasingRecord);

        Map map = new HashMap();
        map.put("chasingMethodDtos",chasingMethodDtos);
        map.put("clueUsers",clueUsers);
        map.put("clueCustomerDtos",clueCustomerDtos);

        return Result.success(map);

    }



}
