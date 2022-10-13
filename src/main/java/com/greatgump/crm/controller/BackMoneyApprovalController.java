package com.greatgump.crm.controller;

import com.greatgump.crm.common.R;
import com.greatgump.crm.entity.BackMoneyApproval;

import com.greatgump.crm.service.BackMoneyApprovalService;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 * 回款审批 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 *
 */

@RestController
@RequestMapping("/crm/collection")
public class BackMoneyApprovalController {

@Autowired
    private BackMoneyApprovalService backMoneyApprovalService;
    @ApiOperation("线索管理页面主界面列表")
    @GetMapping("/crm/backMoneyApproval/list")
public R list(){
    return R.ok().put("backMoneyApproval",backMoneyApprovalService.list());

}

}
