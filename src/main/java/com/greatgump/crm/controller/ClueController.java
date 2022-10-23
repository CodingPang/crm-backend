package com.greatgump.crm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.dto.chasing.ChasingMethodDto;
import com.greatgump.crm.dto.chasing.ChasingRecordDto;
import com.greatgump.crm.dto.clue.*;
import com.greatgump.crm.dto.customerDetails.*;
import com.greatgump.crm.dto.customerDetails.BusinessDto;
import com.greatgump.crm.dto.customerDetails.ContactDto;
import com.greatgump.crm.dto.customerDetails.OrderDto;
import com.greatgump.crm.dto.power.UserDto;
import com.greatgump.crm.entity.*;
import com.greatgump.crm.service.ChasingRecordService;
import com.greatgump.crm.service.ClueService;

import com.greatgump.crm.service.FollowFormService;

import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * <p>
 * 线索管理 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "线索模块说明")
@RestController
@RequestMapping("/crm/clue")
public class ClueController {
    @Autowired
    private ClueService clueService;
    @Autowired
    private FollowFormService followFormService;
    @Autowired
    private ChasingRecordService chasingRecordService;


    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @ApiOperation("获取所有线索的信息")
    @GetMapping("/queryAllLoans/{current}/{size}")
    public Result queryAllLoans(@PathVariable("current")int current,@PathVariable("size")int size) {


//            List<ClueDto> clueDtos = this.clueService.quryallClue();
            List<ClueOrigin> clueOrigins = this.clueService.queryAllClueOrigin();
            List<ClueStatus> clueStatuses = this.clueService.queryAllClueStatus();

            Page<ClueDto> offerListDtoPage = new Page<>(current,size);
            Page<ClueDto> offerListDtoPage1 = this.clueService.queryListClue(offerListDtoPage);
            List<ClueDto> clueDtos = offerListDtoPage1.getRecords();
            long total = offerListDtoPage1.getTotal();

        for (ClueDto clueDto:clueDtos){
                System.out.println(clueDto.getLastFollow());
                System.out.println(clueDto.getCurrentTime());

                int time = (int)(clueDto.getLastFollow().getTime()-clueDto.getCurrentTime().getTime());
                int days = time/1000/60/60/24;
                System.out.println(days);
                clueDto.setNotFollowDays(days);
            }

            Map map = new HashMap();

            map.put("clueDtos",clueDtos);
            map.put("length",total);
            map.put("clueOrigins",clueOrigins);
            map.put("clueStatuses",clueStatuses);

        return Result.success(map);
    }


    @ApiOperation("线索信息预增加操作")
    @GetMapping("/preAdd")
    public Result preAdd() {

//        ClueBoxDto clueBoxDto = new ClueBoxDto();
//        // 1、线索归属
//        List<Clue> clueList = new ArrayList<>();
//        Clue clue = new Clue();
//        clue.setId(1L);
//        clue.setPersonnel("zs");
//        clueList.add(clue);
//        Clue clue1 = new Clue();
//        clue1.setId(2L);
//        clue1.setPersonnel("ls");
//        clueList.add(clue1);
//
//        // 2、线索来源
//        List<FollowForm> sourceList = new ArrayList<>();
//        FollowForm followForm = new FollowForm();
//        followForm.setId(1L);
//        followForm.setFollowSource("主动来电");
//        sourceList.add(followForm);
//        FollowForm followForm1 = new FollowForm();
//        followForm1.setId(2L);
//        followForm1.setFollowSource("客户介绍");
//        sourceList.add(followForm1);
//
//        // 3、线索状态
//        List<FollowForm> statusList = new ArrayList<>();
//        FollowForm followForm01 = new FollowForm();
//        followForm01.setId(1L);
//        followForm01.setFollowType("1");
//        statusList.add(followForm01);
//        FollowForm followForm02 = new FollowForm();
//        followForm02.setId(1L);
//        followForm02.setFollowType("2");
//        statusList.add(followForm02);
//
//
//        clueBoxDto.setSourceList(sourceList);
//        clueBoxDto.setClueList(clueList);
//        clueBoxDto.setStatusList(statusList);
//
////        Map<String, Object> map = new HashMap<>();
////        map.put("cluebox", clueBoxDto);
//
//
//        return Result.success(clueBoxDto);



/*  List<Business> businessList = new ArrayList<>();
  Business business01 = new Business();
  business01.setId(1L);
  business01.setBussinessStage(1L);
  Business business02 = new 1();
  business02.setId(2L);
  business02.setBussinessStage(2L);
  Business business03 = new Business();
  business03.setId(3L);
  business03.setBussinessStage(3L);*/
        List<ClueOrigin> clueOrigins = this.clueService.queryAllClueOrigin();
        List<ClueStatus> clueStatuses = this.clueService.queryAllClueStatus();
        List<ClueUser> clueUsers = this.clueService.queryAllClueUser();
        List<ClueDept> clueDepts = this.clueService.queryAllClueDept();
        List<ClueCustomerDto> clueCustomerDtos = this.clueService.queryAllClueCustomerDto();


        Map map = new HashMap();

        map.put("clueOrigins",clueOrigins);
        map.put("clueStatuses",clueStatuses);
        map.put("clueUsers",clueUsers);
        map.put("clueDepts",clueDepts);
        map.put("clueCustomerDtos",clueCustomerDtos);


        return Result.success(map);
    }



    @ApiOperation("新增操作")
    @PostMapping("/preAddcontact")
    public Result<Clue> preAddcontact(@RequestBody ClueReceiveDto clueReceiveDto) {

        long time = new Date().getTime();
        Date date = new Date(time);
        System.out.println(date);
        clueReceiveDto.setLastTime(date);

        try {
            this.clueService.addClueReceive(clueReceiveDto);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed();
        }

        return Result.success();

    }


    @ApiOperation("主页面预编辑")
    @GetMapping("/crm/clue/preUpdate/{id}")
    public Result preEdit(@PathVariable("id") Long id){

        List<ClueOrigin> clueOrigins = this.clueService.queryAllClueOrigin();
        List<ClueStatus> clueStatuses = this.clueService.queryAllClueStatus();
        List<ClueUser> clueUsers = this.clueService.queryAllClueUser();
        List<ClueDept> clueDepts = this.clueService.queryAllClueDept();
        List<ClueCustomerDto> clueCustomerDtos = this.clueService.queryAllClueCustomerDto();


        ClueReceiveDto clueReceiveDto1 = this.clueService.editPreClueReceive(id);
        Map map = new HashMap();
        map.put("clueReceiveDto1",clueReceiveDto1);
        map.put("clueOrigins",clueOrigins);
        map.put("clueStatuses",clueStatuses);
        map.put("clueUsers",clueUsers);
        map.put("clueDepts",clueDepts);
        map.put("clueCustomerDtos",clueCustomerDtos);

        return Result.success(map);
    }

    @ApiOperation("主页面编辑")
    @PutMapping("/crm/clue/update")
    public Result update(@RequestBody ClueReceiveDto clueReceiveDto) {

//        boolean c = clueService.update(clueReceiveDto) ;
//        return Result.judge(c);

        try {
            this.clueService.updateClueReceiveByClueReceiveDto(clueReceiveDto);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed();
        }
        return Result.success();
    }


//    @ApiOperation("线索管理页面修改")
//    @GetMapping("/modify/{id}")
//    public Result<ClueDto> update(Clue clue) {
//         boolean flag = clueService.updateById(clue);
//       //客户名称
//    ClueDto clueDto = new ClueDto();
//    clueDto.setId(1L);
//    clueDto.setUsername("上海大华科技有限公司");
//        //归属人员
//        ClueDto clueDto01 = new ClueDto();
//        clueDto01.setId(1l);
//        clueDto01.setUsername("张三");
//        clueDto01.setContacts("zs");
//
//
//
//         //联系人
//        ClueDto clueDto02 = new ClueDto();
//        clueDto02.setId(1l);
//        clueDto02.setContacts("张三");
//
//        //联系号码
//
//        ClueDto clueDto03 = new ClueDto();
//        clueDto03.setId(1l);
//        clueDto03.setPhone("17715214455");
//         //最后跟进
//
//        List





//        return Result.judge(flag);
//
//
//    }

//    @ApiOperation("线索联系信息编辑")
//    @PutMapping("/ contact")
//    public Result updateContact(@RequestBody ClueDto clueDto) {
//
//
//        return Result.success();


//    }




    @ApiOperation("线索页面删除")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id) {

        try {
            this.clueService.deleteClueById(id);

        } catch (Exception e) {
            e.printStackTrace();
            Result.failed();
        }

        return Result.success();

    }


    @ApiOperation("线索页面批量删除")
    @DeleteMapping("/deletion")
    public Result deletion(@RequestBody List<ClueReceiveDto> clueReceiveDtos) {
        try {
            for (ClueReceiveDto clueReceiveDto : clueReceiveDtos) {
                this.clueService.deleteClueById(clueReceiveDto.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Result.failed();
        }
        return Result.success();
    }

    @ApiOperation("线索页面条件查询")
    @PostMapping("/selectByCondition")
    public Result selectByCondition(@RequestBody ClueSelectCondition clueSelectCondition) {
//        String startTime = null;
//        String endTime = null;
//        Date startDate = null;
//        Date endDate = null;
//
//        String selectTime = clueSelectCondition.getSelectTime();
        String username = clueSelectCondition.getUsername();
        System.out.println(username);
        Long originId = clueSelectCondition.getOriginId();
        Long statusId = clueSelectCondition.getStatusId();
        Date startTime = clueSelectCondition.getStartTime();
        Date endTime = clueSelectCondition.getEndTime();

//
//        if (selectTime != null && !selectTime.equals("")){
//            String[] times = selectTime.split(",");
//            startTime = times[0];
//            endTime = times[1];
//
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            try {
//                startDate = sdf.parse(startTime);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            try {
//                endDate = sdf.parse(endTime);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }

//        ClueReceiveDto ClueReceiveDto = this.clueService.selectClueReceiveDtoByCondition(username,originId,statusId,startTime,endTime);
       List<ClueDto> clueDtos = this.clueService.selectClueDtoByCondition(username,originId,statusId,startTime,endTime);

        Map map = new HashMap();
        map.put("clueDtos",clueDtos);

        return Result.success(map);
    }

    @ApiOperation("线索页面跟进")
    @GetMapping("/followUpPre/{id}")
    public Result followUpPre(@PathVariable("id")Long id) {
        List<ChasingMethodDto> chasingMethodDtos = this.chasingRecordService.queryAllChasingMethod();
        List<ClueUser> clueUsers = this.clueService.queryAllClueUser();

        Long followFormId = id;

        Map map = new HashMap();

        map.put("chasingMethodDtos",chasingMethodDtos);
        map.put("clueUsers",clueUsers);
        map.put("followFormId",followFormId);
        return Result.success(map);
    }

    @ApiOperation("线索页面跟进保存")
    @PostMapping("/followUp")
    public Result followUp(ChasingRecord chasingRecord) {
        try {
            this.chasingRecordService.addChasingRecord(chasingRecord);

        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed();
        }
        return Result.success();
    }

    @ApiOperation("客户明细")
    @GetMapping("/customerDetail/{id}")
    public Result customerDetails(@PathVariable("id")Long id) {

        MainInfoDto mainInfoDto = this.clueService.queryMainInfoById(id);
        List<ContactDto> contactDtos = this.clueService.queryContactDto(id);
        List<ChasingRecordDto> chasingRecordDtos = this.clueService.queryAllChasingRecord(id);
        List<ClueWorKOrderDto> worKOrderDtos = this.clueService.querAllWorKOrderDtos(id);
        List<OrderDto> orderDtos = this.clueService.queryAllOrderDto(id);
        List<InvoiceDto> invoiceDtos = this.clueService.queryAllInvoiceDtos(id);
        List<CostDto> costDtos = this.clueService.queryAllCostDtos(id);
        List<EnclosureDto> enclosureDtos = this.clueService.queryAllEnclosureDtos(id);
        List<FollowPlan> followPlans = this.clueService.queryAllFollowPlans(id);
        List<BelongRecord> belongRecords = this.clueService.queryAllBelongRecords(id);
        List<BusinessDto> businessDtos = this.clueService.queryAllBusinessDtos(id);

        Map map = new HashMap();
        map.put("mainInfoDto",mainInfoDto);
        map.put("contactDtos",contactDtos);
        map.put("chasingRecordDtos",chasingRecordDtos);
        map.put("worKOrderDtos",worKOrderDtos);
        map.put("orderDtos",orderDtos);
        map.put("invoiceDtos",invoiceDtos);
        map.put("costDtos",costDtos);
        map.put("enclosureDtos",enclosureDtos);
        map.put("followPlans",followPlans);
        map.put("belongRecords",belongRecords);
        map.put("businessDtos",businessDtos);

        return Result.success(map);
    }



}