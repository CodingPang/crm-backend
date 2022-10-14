package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.WorkorderDto;
import com.greatgump.crm.dto.WorkorderDto2;

import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Order;
import com.greatgump.crm.entity.Workorder;
import com.greatgump.crm.service.WorkorderService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/workorder/{current}/{size}")
    public Result<List<Workorder>> getAllWorkorder(@PathVariable("current") int current, @PathVariable("size") int size){
        Page<Workorder> workorderPage = new Page<>(current,size);
        Page<Workorder> pageInfo = workorderService.queryAllWorkorder(workorderPage);
        WorkorderDto workorderDto = new WorkorderDto(23333,"工单标题1",new Date(System.currentTimeMillis()),"张三三","李四四",0,"非常紧急");
        return Result.success(
                pageInfo.getRecords(), // 通过mybatis封装好的所有的工单，是一个Workorder类型的List集合
                pageInfo.getTotal() // mybatisplus统计的总数
                );
    }
    @ApiOperation("预新增工单信息")
    @GetMapping("/preorder")
    public Result<Map<String,Object>> preorder(){
        WorkorderDto2 workorderDto01 = new WorkorderDto2();
        Customer customer01 = new Customer();
        customer01.setId(1);
        customer01.setCustomerName("上海大华科技有限公司");
        workorderDto01.setCustomerName(customer01);
        Order order01 = new Order();
        order01.setId(1L);
        order01.setOrderTitle("客户购买CRM系统");
        workorderDto01.setRepairOrderTitle("客户退款");
        workorderDto01.setEmergencyDegree(0);
        workorderDto01.setWorkOrderDetails("客户使用的系统出现了问题，请技术修复");
        WorkorderDto2 workorderDto02 = new WorkorderDto2();
        Customer customer02 = new Customer();
        customer02.setId(2L);
        customer02.setCustomerName("苏州智慧科技有限公司");
        workorderDto01.setCustomerName(customer02);
        Order order02 = new Order();
        order02.setId(3L);
        order02.setOrderTitle("客户反馈系统问题");
        workorderDto01.setRepairOrderTitle("维护问题");
        workorderDto01.setEmergencyDegree(0);
        workorderDto01.setWorkOrderDetails("客户使用的系统崩溃了，请通知技术人员");

        Map<String,Object> map = new HashMap<>();
        map.put("preorder",workorderDto01);
        map.put("preorder2",workorderDto02);
        return Result.success(map);
    }
//    @ApiOperation("新建工单")
//    @PutMapping("/addWorkorder")
//    public Result addWorkorder(@RequestBody WorkorderDto2 workorderDto2){
//        int i = workorderService.addWororder(workorderDto2);
//         return Result.success();}
    @ApiOperation("根据条件查询工单")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @PostMapping("/queryByWorkorder/{current}/{size}")
    public Result<List<Workorder>>  queryByWorkorder(@PathVariable("current") int current, @PathVariable("size") int size,String repairOrderTitle, Integer workOrderStatus, Integer emergencyDegree){
        Page<Workorder> workorderPage = new Page<>(current,size);
        Page<Workorder> pageInfo = workorderService.queryByWorkorder(workorderPage,repairOrderTitle,workOrderStatus,emergencyDegree);

        return  Result.success(
                pageInfo.getRecords(), // 通过mybatis封装好的所有的工单，是一个Workorder类型的List集合
                pageInfo.getTotal());// mybatisplus统计的总数
    }




    }







