package com.greatgump.crm.controller;

import com.greatgump.crm.common.R;
import com.greatgump.crm.entity.CalcUnit;
import com.greatgump.crm.entity.Offer;
import com.greatgump.crm.service.CalcUnitService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 * 计量单位 前端控制器
 * </p>。
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@RestController
//@RequestMapping("/crm/calc-unit")
public class CalcUnitController {
    @Autowired
    private CalcUnitService calcUnitService;

    @ApiOperation("计量单位主界面列表")
    @GetMapping("/crm/calcUnit/list")
    public R list(){
        return R.ok().put("calcUnitlist",calcUnitService.list());
    }

    @ApiOperation("计量单位页面增加")
    @PostMapping("/crm/calcUnit/add")
    public R add(CalcUnit calcUnit){

        calcUnitService.save(calcUnit);
        return R.ok().put("calcUnitadd",calcUnit);
    }

    @ApiOperation("计量单位页面修改")
    @PutMapping("/crm/calcUnit/update")
    private R update(CalcUnit calcUnit){

        calcUnitService.updateById(calcUnit);
        return R.ok().put("calcUnitupdate",calcUnit);
    }

    @ApiOperation("计量单位页面删除")
    @DeleteMapping("/crm/calcUnit/delete")
    public R delete(Long id){
        calcUnitService.removeById(id);
        return R.ok().put("calcUnitdelete",id);
    }



}
