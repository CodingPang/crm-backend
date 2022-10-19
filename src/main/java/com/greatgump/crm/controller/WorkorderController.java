package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;

import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Workorder;
import com.greatgump.crm.service.WorkorderService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 工单 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags ="工单管理说明")
@RestController
public class WorkorderController {
    @Autowired
    private WorkorderService workorderService;

    //新增工单
    @ApiOperation("获取所有工单")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current", value = "当前页数", required = true), @ApiImplicitParam(name = "size", value = "每页的条数", required = true)})
    @GetMapping("/workorder/{current}/{size}")
    public Result<List<WorkorderDto>> getAllWorkorder(@PathVariable("current") int current, @PathVariable("size") int size) {
//        Page<Workorder> workorderPage = new Page<>(current, size);
//        Page<Workorder> pageInfo = workorderService.queryAllWorkorder(workorderPage);
//        return Result.success(workorderPage.getRecords(),
//                pageInfo.getTotal());
        WorkorderDto workorderDto = new WorkorderDto();
        workorderDto.setRepairOrderTitle("工单标题1");
        workorderDto.setHandler("sdd");
        workorderDto.setInitiator("ww");
        workorderDto.setEmergencyDegree(1);
        workorderDto.setWorkOrderNumber(45444);
        workorderDto.setWorkOrderStatus(0);

        WorkorderDto workorderDto1 = new WorkorderDto();
        workorderDto1.setRepairOrderTitle("工单标题2");
        workorderDto1.setHandler("sd1");
        workorderDto1.setInitiator("ssa");
        workorderDto1.setEmergencyDegree(1);
        workorderDto1.setWorkOrderNumber(455544);
        workorderDto1.setWorkOrderStatus(1);
        List<WorkorderDto> list = new ArrayList<>();
        list.add(workorderDto);
        list.add(workorderDto1);
        return Result.success(list,4L);
    }

    @ApiOperation("我发起的工单")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current", value = "当前页数", required = true), @ApiImplicitParam(name = "size", value = "每页的条数", required = true)})
    @GetMapping("/workorder/{uid}/{current}/{size}")
    public Result<List<Workorder>> getWorkorderByUid(@PathVariable("uid") int uid,@PathVariable("current") int current, @PathVariable("size") int size) {
        Page<Workorder> workorderPage = new Page<>(current, size);
        Page<Workorder> pageInfo = workorderService.getWorkorderByUid(uid,workorderPage);
        return Result.success(workorderPage.getRecords(),
                pageInfo.getTotal());
    }


    @ApiOperation("新增工单信息")
    @PostMapping("/preorder")
    public Result addWorkorder(WorkorderDto2 workorderDto2){
         boolean flag = workorderService.addWorkorder(workorderDto2);
        return Result.success(flag);


    }

    @ApiOperation("根据条件查询工单")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current", value = "当前页数", required = true), @ApiImplicitParam(name = "size", value = "每页的条数", required = true)})
    @GetMapping("/queryByWorkorder/{current}/{size}")
    public Result<List<Workorder>> queryByWorkorder(@PathVariable("current") int current, @PathVariable("size") int size, String repairOrderTitle, Integer workOrderStatus, Integer emergencyDegree) {
        Page<Workorder> workorderPage = new Page<>(current, size);
        Page<Workorder> pageInfo = workorderService.queryByWorkorder(workorderPage, repairOrderTitle, workOrderStatus, emergencyDegree);
        return Result.success(workorderPage.getRecords(),pageInfo.getTotal());
    }

    @ApiOperation("根据id删除工单")
    @DeleteMapping("/deleteOrder/{id}")
    public Result deleteOrder(@PathVariable("id") Integer id) {
        boolean flag =   workorderService.deleteOrder(id);
        return Result.judge(flag);
    }
        @ApiOperation("工单信息批量删除")
        @DeleteMapping("/deletes")
        public Result deletes(@RequestBody List<Workorder> workorders){
              boolean b  = false;
            for (Workorder workorder : workorders) {

                 b =  workorderService.deletes(workorders);

            }
           return  Result.judge(b);


    }
    @ApiOperation("工单详情")
    @GetMapping("/queryorder/{id}")
    public Result<List<Workorder>> queryorderByid(@PathVariable("id")Long id){

        return Result.success();


    }
    @ApiOperation("分配工单")
    @PutMapping("/updateHandler")
    public Result<Workorder>  updateHandler(String handler){
        boolean flag = workorderService.updateByhandler(handler);
        return  Result.judge(flag);
    }
}







