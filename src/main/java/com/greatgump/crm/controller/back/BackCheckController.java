package com.greatgump.crm.controller.back;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.back.BackCheckDto;
import com.greatgump.crm.dto.back.BackRecordDto;
import com.greatgump.crm.service.BackCheckService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 回款审批 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Api(tags = "回款审批")
@RestController
@RequestMapping("/crm/backcheck")
public class BackCheckController {

  @Autowired
  private BackCheckService backCheckService;


  @ApiOperation("查询所有的回款审批")
  @GetMapping("/backchecks/{current}/{size}")
  @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
  public Result<List<BackCheckDto>> queryAllBackCheck(@PathVariable("current") int current, @PathVariable("size") int size) {
    Page<BackCheckDto> backCheckDtoPage =  new Page<>(current,size);
    Page<BackCheckDto> pageInfo = backCheckService.queryAllBackCheck(backCheckDtoPage);
    return Result.success(pageInfo.getRecords(),pageInfo.getTotal());
  }

  @ApiOperation("回款审批详情")
  @GetMapping("/preUpdate")
  public Result<BackCheckDto> queryAllBackCheck() {

    return Result.success(new BackCheckDto());
  }

  @ApiOperation("审批回款")
  @PutMapping("/backchecks/{checkId}")
  public Result editOneBackCheck(@RequestBody BackRecordDto backRecordDto){
    return Result.success();
  }


}
