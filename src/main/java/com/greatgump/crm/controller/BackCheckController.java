package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.BackCheckDto;
import com.greatgump.crm.service.BackCheckService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
  @GetMapping("/backchecks")
  public Result<BackCheckDto> queryAllBackCheck(){
  return Result.success();
  }

}
