package com.greatgump.crm.controller;

import com.greatgump.crm.common.R;
import com.greatgump.crm.entity.Assort;
import com.greatgump.crm.entity.CalcUnit;
import com.greatgump.crm.service.AssortService;
import com.greatgump.crm.service.CalcUnitService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@RestController
//@RequestMapping("/crm/assort")
public class AssortController {

    @Autowired
    private AssortService assortService;

    @ApiOperation("产品分类主界面列表")
    @GetMapping("/crm/assort/list")
    public R list(){
        return R.ok().put("assortlist",assortService.list());
    }

    @ApiOperation("产品分类页面增加")
    @PostMapping("/crm/assort/add")
    public R add(Assort assort){

        assortService.save(assort);
        return R.ok().put("assortadd",assort);
    }

    @ApiOperation("计量单位页面修改")
    @PutMapping("/crm/assort/update")
    private R update(Assort assort){

        assortService.updateById(assort);
        return R.ok().put("assortupdate",assort);
    }

    @ApiOperation("计量单位页面删除")
    @DeleteMapping("/crm/assort/delete")
    public R delete(Long id){
        assortService.removeById(id);
        return R.ok().put("assortdelete",id);
    }





}
