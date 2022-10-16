package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;

import com.greatgump.crm.entity.Assort;
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
    public Result<List<Workorder>> getAllWorkorder(@PathVariable("current") int current, @PathVariable("size") int size) {
        Page<Workorder> workorderPage = new Page<>(current, size);
        Page<Workorder> pageInfo = workorderService.queryAllWorkorder(workorderPage);
        WorkorderDto workorderDto = new WorkorderDto(23333, "工单标题1", new Date(System.currentTimeMillis()), "张三三", "李四四", 0, 0);
        return Result.success(
                pageInfo.getRecords(), // 通过mybatis封装好的所有的工单，是一个Workorder类型的List集合
                pageInfo.getTotal() // mybatisplus统计的总数
        );
    }

    @ApiOperation("预新增工单信息")
    @GetMapping("/preorder")
    public Result<Map<String,Object>> preorder() {
        //封装关联客户列表
        Customer customer01 = new Customer();
        customer01.setId(1L);
        customer01.setCustomerName("上海大华科技有限公司");

        Customer customer02 = new Customer();
        customer02.setId(2L);
        customer02.setCustomerName("苏州智慧科技有限公司");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer01);
        customers.add(customer02);
        //封装关联订单列表
        OrderDto orderDto01 = new OrderDto(1L,"订单标题一");
        OrderDto orderDto02 = new OrderDto(2L,"订单标题二");
        List<OrderDto> orderDtos = new ArrayList<>();
        orderDtos.add(orderDto01);
        orderDtos.add(orderDto02);
        //紧急状态封装
        WorkorderDto workorderDto01 = new WorkorderDto();
        workorderDto01.setEmergencyDegree(0);
        WorkorderDto workorderDto02 = new WorkorderDto();
        workorderDto02.setEmergencyDegree(1);
        List<WorkorderDto> workorderDtos = new ArrayList<>();
        workorderDtos.add(workorderDto01);
        workorderDtos.add(workorderDto02);

        Map<String,Object> map = new HashMap<>();
        map.put("order",customers);
        map.put("order1",orderDtos);
        map.put("order2",workorderDtos);

        return Result.success(map,2l);


    }

    //    @ApiOperation("新建工单")
//    @PutMapping("/addWorkorder")
//    public Result addWorkorder(@RequestBody WorkorderDto2 workorderDto2){
//        int i = workorderService.addWororder(workorderDto2);
//         return Result.success();}
    @ApiOperation("根据条件查询工单")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current", value = "当前页数", required = true), @ApiImplicitParam(name = "size", value = "每页的条数", required = true)})
    @PostMapping("/queryByWorkorder/{current}/{size}")
    public Result<List<Workorder>> queryByWorkorder(@PathVariable("current") int current, @PathVariable("size") int size, String repairOrderTitle, Integer workOrderStatus, Integer emergencyDegree) {
        Page<Workorder> workorderPage = new Page<>(current, size);
        Page<Workorder> pageInfo = workorderService.queryByWorkorder(workorderPage, repairOrderTitle, workOrderStatus, emergencyDegree);

        return Result.success(
                pageInfo.getRecords(), // 通过mybatis封装好的所有的工单，是一个Workorder类型的List集合
                pageInfo.getTotal());// mybatisplus统计的总数
    }

    @ApiOperation("根据id删除工单")
    @DeleteMapping("/deleteOrder/{id}")
    public Result deleteOrder(@PathVariable("id") Integer id) {
        boolean b =   workorderService.removeById(id);
        return Result.success();
    }
        @ApiOperation("工单信息批量删除")
        @DeleteMapping("/deletes")
        public Result deletes(@RequestBody List<Workorder> workorders){
            for (Workorder workorder : workorders) {

             boolean b =  workorderService.removeById(workorder.getId());

            }
           return  Result.success();


    }
    @ApiOperation("工单详情")
    @PutMapping("/updateorder/{id}")
    public Result<WorkOderDetailsDto> update(@PathVariable("id")Long id){

       Workorder workorder = new Workorder();
        workorder.setId(1L);
        workorder.setCustomerName("上海大华科技有限公司");
        workorder.setHandler("张三");
        workorder.setLinkman("应南飞");

        WorkOderDetailsDto workOderDetailsDto = new WorkOderDetailsDto();
        workOderDetailsDto.setWorkorder(workorder);

        return Result.success(workOderDetailsDto);


    }
}







