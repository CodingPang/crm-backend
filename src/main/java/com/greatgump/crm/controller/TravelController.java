package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.service.ApprovalStatusService;
import com.greatgump.crm.service.CustomerService;
import com.greatgump.crm.service.OrderService;
import com.greatgump.crm.service.TravelService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 出差表 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "出差功能说明")
@RestController
@RequestMapping("/crm/travel")
public class TravelController {

    @Autowired
    private TravelService travelService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ApprovalStatusService approvalStatusService;


    @ApiOperation("获取所有的出差信息")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/queryAllTravels/{current}/{size}")
    public Result<List<TravelDto>> queryAllTravels(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {

        Page<TravelDto> travelDtoPage = new Page<>(current,size);
        Page<TravelDto> pageInfo = travelService.queryAllTravel(travelDtoPage);

        return Result.success(pageInfo.getRecords(), pageInfo.getTotal());
    }

        @ApiOperation("出差新增")
        @PostMapping("/insertTravel")
        public Result insertTravel(@RequestBody AddedTravelDto addedTravelDto){

            int insertTravel = travelService.insertTravel(addedTravelDto);

            return Result.success(insertTravel);


    }

    @ApiOperation("关联客户下拉框，会返回客户名称及id")
    @GetMapping("/loanCustomer")
    public Result<List<LuoDto2>> loanCustomer(){
        return Result.success(customerService.queryName());
    }

//    @ApiOperation("关联订单下拉框，会返回订单名称及id")
//    @GetMapping("/loanOrder")
//    public Result<List<LoanOrderDto>> loanOrder(){
//        return Result.success(orderService.queryOrder());
//    }

    @ApiOperation("获取详情")
    @GetMapping("/queryTravelDetails/{id}")
    public Result<TravelDetailDto> queryTravelDetails(@PathVariable("id")Integer id) {
           TravelDetailDto travelDetailDto = travelService.queryTravelDetail(id);

         return Result.success(travelDetailDto);
    }

    @ApiOperation("获取编辑详情")
    @GetMapping("/queryEditTravel/{id}")
    public Result<EditTravelDto> queryEditTravel(@PathVariable("id") Integer id) {

        return Result.success(travelService.queryEditTravel(id));
    }

    @ApiOperation("审批状态下拉框，会返回审批状态及id")
    @GetMapping("/queryApprovalStatus")
    public Result<List<ApprovalStatusDto>> queryApprovalStatus(){
        return Result.success(approvalStatusService.queryApprovalStatus());
    }
    @ApiOperation("出差页面关键词查询")
    @PostMapping("/queryTravelDynamic")
    public Result<List<TravelDto>>  queryTravelDynamic(@RequestBody TravelDynamicDto travelDynamicDto){

        List<TravelDto> travelDtoPage = travelService.queryTravelDynamic(travelDynamicDto);
        return Result.success(travelDtoPage);
    }
        @ApiOperation("出差页面修改")
        @PutMapping("/updateTravel")
        public Result<AddedTravelDto> updateTravel(@RequestBody AddedTravelDto addedTravelDto){
            int updateTravel = travelService.updateTravel(addedTravelDto);
            if (updateTravel>0){
                return Result.success();
            }else {
                return Result.failed();
            }

        }

    @ApiOperation("出差页面删除")
    @DeleteMapping("/deleteTravel/{id}")
    public Result deleteTravel(@PathVariable("id")Long id){

        boolean b = travelService.removeById(id);
        return Result.judge(b);


    }
    @ApiOperation("出差页面批量删除")
    @DeleteMapping("/deletebatch")
    public Result deletebatch(@RequestBody List<Long> ids){
        boolean b =false;
        for (Long id : ids) {
            b = travelService.removeById(id);
        }



        return Result.judge(b);
    }
}
