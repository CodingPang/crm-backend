package com.greatgump.crm.controller;

import java.util.Date;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;

import com.greatgump.crm.dto.workorder.WorkOrderOther;
import com.greatgump.crm.dto.workorder.WorkorderFinish;
import com.greatgump.crm.dto.workorder.WorkorderSearch;
import com.greatgump.crm.entity.User;
import com.greatgump.crm.entity.Workorder;
import com.greatgump.crm.service.WorkorderService;
import com.greatgump.crm.utils.NoGenerateUtils;
import com.greatgump.crm.utils.OSSUtil;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

import static org.jacoco.agent.rt.internal_43f5073.core.runtime.AgentOptions.OutputMode.file;

/**
 * <p>
 * 工单 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "工单管理说明")
@RestController
public class WorkorderController {
    @Autowired
    private WorkorderService workorderService;


    //
    @ApiOperation("获取所有工单")
    @GetMapping("/all")
    public Result<Page<Workorder>> getAllWorkorder(WorkorderSearch search) {
        Page<Workorder> page = workorderService.queryByPage(search);

        return Result.success(page);
    }

    @ApiOperation("我发起的工单")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "currentUserId", value = "当前用户的ID", required = true)})
    @GetMapping("/byme")
    public Result<Page<Workorder>> getWorkorderByMe(WorkorderSearch search, Integer currentUserId) {
        Page<Workorder> page = workorderService.queryByPageMe(search, currentUserId);
        return Result.success(page);
    }

    @ApiOperation("我处理的工单")
    @ApiImplicitParam(name = "currentUserId", value = "当前用户的ID", required = true)
    @GetMapping("/byhandle")
    public Result<Page<Workorder>> getWorkorderByHandle(WorkorderSearch search, Integer currentUserId) {
        Page<Workorder> page = workorderService.queryByPageHandle(search, currentUserId);
        return Result.success(page);
    }




    @ApiOperation("文件上传接口--上传成功返回url地址")
    @PostMapping("/file")
    public Result fileup(MultipartFile file) {
        OSSUtil ossUtil = new OSSUtil();
        String fileUrl = ossUtil.uploadDocument(file, "file");
        return Result.success(fileUrl);
    }
    @ApiOperation("获取关联客户--关联订单列表")
    @PostMapping("/list")
    public Result getList( ) {
        List<LoanOrderDto> orderList = workorderService.getOrderList();
        List<LuoDto2> customerList = workorderService.getCustomerList();
        Map<String, List> result = new HashMap<>();
        result.put("orderList",orderList);
        result.put("customerList",customerList);
        return Result.success(result);
    }


    @ApiOperation("新增工单信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId",value = "当前用户的ID",required = true)})
    @PostMapping("/add")
    public Result addWorkorder(@RequestBody WorkorderDto2 workorderDto2, Integer userId) {
        Workorder workorder = new Workorder();
        workorder.setId(0);
        String backMoneyCode = NoGenerateUtils.getBackMoneyCode(userId);
        workorder.setWorkOrderNumber(backMoneyCode);
        workorder.setRepairOrderTitle(workorderDto2.getTitle());
        workorder.setStartTime(new Date());
        workorder.setInitiatorId(userId);
//        workorder.setHandlerId(0);
        workorder.setWorkorderStatus(0);
        workorder.setCustomerId(workorderDto2.getCustomerId());
//        workorder.setContactId(0); //先没有交给编辑时做
//        workorder.setNote(""); //完结货分配时
        workorder.setAttachment(workorderDto2.getAttachment());
        workorder.setContent(workorderDto2.getContent());
        workorder.setOrderId(workorderDto2.getOrderId());
        workorder.setUrgent(workorderDto2.getEmergency());

        System.out.println(workorder);
        boolean flag = workorderService.save(workorder);
        if (flag) {

            return Result.success(flag);
        }
        return Result.failed();

    }

    @ApiOperation("根据id删除工单")
    @DeleteMapping("/del/{id}")
    public Result deleteOrder(@PathVariable("id") Integer id) {
        boolean flag = workorderService.removeById(id);
        if (flag) {
            return Result.success("删除成功！");
        }
        return Result.failed();
    }

    @ApiOperation("工单信息批量删除")
    @PostMapping("/del")
    public Result deletes(@RequestBody List<Integer> idList) {
        if (workorderService.removeBatchByIds(idList)) {
            return Result.success();
        }
        return Result.failed();


    }

    @ApiOperation("工单详情")
    @GetMapping("/detail/{id}")
    public Result<Workorder> detail(@PathVariable("id") Integer id) {
        if(id == null){
            return Result.failed("没有该工单");
        }
        //当用户查看该工单详情时，我们就认为该工单由等待状态进入 判断 状态为1（未处理才将状态修改为） 处理中状态
        Workorder workorder = workorderService.queryById(id);
        if (workorder != null && workorder.getWorkorderStatus()== 1) {
            workorder.setWorkorderStatus(2);//改为处理中
            //更新
            this.workorderService.updateById(workorder);
            return Result.success(workorder);
        }
        if(workorder != null){
            return Result.success(workorder);
        }
        return Result.failed("查询失败！没有该工单");
    }

    @ApiOperation("编辑工单")
    @PutMapping("/update")
    public Result updateHandler(@RequestBody WorkorderDto2 workorderDto2) {//发送一行的数据过来
        //查询
        Workorder work = workorderService.getById(workorderDto2.getWorkOrderId());
        //设值
        work.setCustomerId(workorderDto2.getCustomerId());
        work.setOrderId(workorderDto2.getOrderId());
        work.setUrgent(workorderDto2.getEmergency());
        work.setRepairOrderTitle(workorderDto2.getTitle());
        work.setContent(workorderDto2.getContent());
        work.setAttachment(workorderDto2.getAttachment());
        if (workorderService.updateById(work)) {
            return Result.success();
        }
        return Result.failed();
    }





    @ApiOperation("分配工单--获取人员列表")
    @GetMapping("/users")
    public Result users() {//发送一行的数据过来
        List<User> userList = workorderService.getUserList();
        return Result.success(userList);
    }
    @ApiOperation("分配工单")
    @PostMapping("/distribution")
    public Result distribution(Integer chooseUserId,String note,@RequestBody List<Integer> chooseIdList) {//发送一行的数据过来

        List<Workorder> updateWorkorderList = new ArrayList<>();
        for (Integer id : chooseIdList) {
            Workorder workorder = this.workorderService.getById(id);
            workorder.setHandlerId(chooseUserId);//更新
            workorder.setNote(note);
            updateWorkorderList.add(workorder);
        }

        boolean update = workorderService.updateBatchById(updateWorkorderList);
        if(update){
            return Result.success();
        }
        return Result.failed("更新失败！");
    }

    @ApiOperation("完结工单")
    @PostMapping("/finish")
    public Result finish(@RequestBody WorkorderFinish finish) {//发送一行的数据过来
        Workorder workorder = this.workorderService.getById(finish.getFinishId());
        workorder.setHandlerId(finish.getCurrentUserId());
        workorder.setWorkorderStatus(3);
        workorder.setNote(finish.getNote());
        boolean update = this.workorderService.updateById(workorder);
        if(update){
            return Result.success();
        }
        return Result.failed("操作失败！");
    }
    @ApiOperation("转交他人处理")
    @PostMapping("/other")
    public Result other(@RequestBody WorkOrderOther other) {//发送一行的数据过来
        if(other.getCurrentOrderId() == null){
            return Result.failed("操作失败");
        }
        Workorder workorder = this.workorderService.getById(other.getCurrentOrderId());
        if(workorder == null){
            return Result.failed();
        }
        workorder.setHandlerId(other.getChoosePersonId());
        workorder.setReason(other.getReason());
        boolean update = this.workorderService.updateById(workorder);
        if(update){
            return Result.success();
        }
        return Result.failed("操作失败！");
    }


}







