package com.greatgump.crm.controller.back;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.back.BackCheckDto;
import com.greatgump.crm.dto.back.BackRecordPreDto;
import com.greatgump.crm.entity.BackRecord;
import com.greatgump.crm.service.BackCheckService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
  @ApiImplicitParams(value = {
      @ApiImplicitParam(name = "current", value = "当前页数", required = true),
      @ApiImplicitParam(name = "size", value = "每页的条数", required = true)})
  public Result<List<BackRecord>> queryAllBackCheck(@PathVariable("current") Integer current,
      @PathVariable("size") Integer size) {
    //1.创建page对象
    Page<BackRecord> backCheckDtoPage = new Page<>(current, size);
    //2.调用方法，分页查询
    Page<BackRecord> pageInfo = backCheckService.queryAllBackCheck(backCheckDtoPage);
    return Result.success(pageInfo.getRecords(), pageInfo.getTotal());
  }

  @ApiOperation("条件查询所有的回款审批")
  @PostMapping("/backchecks/{current}/{size}")
  @ApiImplicitParams(value = {
      @ApiImplicitParam(name = "current", value = "当前页数", required = true),
      @ApiImplicitParam(name = "size", value = "每页的条数", required = true)})
  public Result<List<BackRecord>> queryAllBackCheckByCondition(
      @PathVariable("current") Integer current, @PathVariable("size") Integer size,
      Integer checkStatus, String submitStartTime, String submitEndTime) {

    // 1、条件查询出所有的审批记录
    List<BackRecord> backRecordList = backCheckService.queryAllByCondition((current - 1) * size,
        size, checkStatus, submitStartTime, submitEndTime);

    return Result.success(backRecordList, Long.valueOf(backRecordList.size()));
  }


  @ApiOperation("回款审批详情")
  @ApiImplicitParams(value = {
      @ApiImplicitParam(name = "id", value = "该回款记录的主键id", required = true)})
  @GetMapping("/preUpdate/{id}")
  public Result<BackRecord> queryAllBackCheck(@PathVariable("id") Integer id) {
    BackRecord backRecord = backCheckService.preUpdate(id);
    return Result.success(backRecord, 1L);
  }

  @ApiOperation("审批回款")
  @ApiImplicitParams(value = {
      @ApiImplicitParam(name = "recordId", value = "该回款记录的主键id", required = true)
  /*@ApiImplicitParam(name = "checkStatus", value = "审批状态(0表示待审批，1表示已通过，2表示已驳回)", required = true),
      @ApiImplicitParam(name = "remark", value = "备注", required = false*/
  })
  @PutMapping("/backchecks/{recordId}")
  public Result editOneBackCheck(@PathVariable("recordId") Integer id,
       @RequestBody BackCheckDto backCheckDto) {
    boolean flag = backCheckService.updateOne(id, backCheckDto.getCheckStatus(), backCheckDto.getRemark());

    if (flag){
      return Result.success();
    }
    return Result.failed();
  }


}
