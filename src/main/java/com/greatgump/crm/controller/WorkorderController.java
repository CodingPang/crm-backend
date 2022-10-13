package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.common.R;
import com.greatgump.crm.entity.Contact;
import com.greatgump.crm.entity.Workorder;
import com.greatgump.crm.service.WorkorderService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 工单 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@RestController
public class WorkorderController {
    @Autowired
    private WorkorderService workorderService;
    //新增工单
    @ApiOperation("获取所有工单")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/workorder/{current}/{size}")
    public R getAllWorkorder(@PathVariable("current") int current, @PathVariable("size") int size){
        Page<Workorder> workorderPage = new Page<>(current,size);
        Page<Workorder> pageInfo = workorderService.queryAllWorkorder(workorderPage);
        return R.ok().put("pageInfo",pageInfo);
    }
    @ApiOperation("新建工单")
    @PutMapping("/addWorkorder")
    public R addWorkorder(@RequestBody Workorder workorder){
        int i = workorderService.addWororder(workorder);
         return i>0?R.ok():R.error();
    }
    @ApiOperation("删除一个工单")
    @DeleteMapping("/deleteWorkorder")
    public R deleteByWorkorder(@PathVariable Integer id){
        boolean b = workorderService.removeById(id);
        return b?R.ok():R.error();
    }


}




