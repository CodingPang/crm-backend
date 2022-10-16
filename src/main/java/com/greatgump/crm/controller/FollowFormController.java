package com.greatgump.crm.controller;

import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.*;
import com.greatgump.crm.service.FollowFormService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * <p>
 * 跟进表 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-15 04:12:20
 */
@RestController
@RequestMapping("/crm/follow-form")
public class FollowFormController {
    @Autowired
    private FollowFormService followFormService;

    @ApiOperation("获取所有的跟进管理信息")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/queryAllFollowForms/{current}/{size}")
    public Result<Map<String,Object>> queryAllLoans(@PathVariable("current") Integer current, @PathVariable("size") Integer size){
        FollowFormDto followFormDto = new FollowFormDto();

        // 1、所有联系人
        FollowForm followForm01 = new FollowForm();
        followForm01.setId(1L);
        followForm01.setContactss("李洪");
        FollowForm followForm02 = new FollowForm();
        followForm02.setId(2L);
        followForm02.setContactss("赵柳");

        List<FollowForm> followFormList = new ArrayList<>();
        followFormList.add(followForm01);
        followFormList.add(followForm02);


        // 所有的客户
        Customer customer01 = new Customer();
        customer01.setId(1L);
        customer01.setCustomerName("上海大华科技有限公司");
        Customer customer02 = new Customer();
        customer02.setId(2L);
        customer02.setCustomerName("四川航空公司");
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer01);
        customerList.add(customer02);



        // 加入list

        Map<String,Object> map = new HashMap<>();
        map.put("followForm",followFormList);
        return Result.success(map,4L);
    }

    @ApiOperation("获取详情")
    @GetMapping("/queryAllManagement/{id}")
    public Result<Map<String,Object>> queryAllLoans(@PathVariable("id")Long id) {
        ManagementDot managementDot = new ManagementDot();
        managementDot.setCustomerName("与客户沟通报价事宜");
        managementDot.setFollowTime(new Date());
        managementDot.setCustomerName("上海大华科技有限公司");
        managementDot.setPersonCharge("赵刚");
        managementDot.setFollowType("线索跟进");
        managementDot.setFollowMethod("到访");
        managementDot.setContactPersonnel("李红");
        managementDot.setContactNumber("12233446343");
        managementDot.setCreationTime(new Date());


        Map<String, Object> map = new HashMap<>();
        map.put("management",managementDot);
        return Result.success(map);
    }

    @ApiOperation("跟进记录下拉框")
    @PostMapping("/pre")
    public Result<Map<String ,Object>> preAdd(){
        FollowFormBoxDto followFormBoxDto = new FollowFormBoxDto();

        List<Management> managementList0 = new ArrayList<>();
        Management management6 = new Management();
        management6.setId(1L);
        management6.setContactPersonnel("上海大华科技有限公司");
        managementList0.add(management6);
        Management management7 = new Management();
        management7.setId(1L);
        management7.setContactPersonnel("中国航空公司");
        managementList0.add(management7);

        List<Management> managementList = new ArrayList<>();
        Management management = new Management();
        management.setId(1L);
        management.setPersonCharge("赵刚");
        managementList.add(management);

        Management management1 = new Management();
        management1.setId(2L);
        management1.setPersonCharge("张明");
        managementList.add(management1);


        List<Management> managementList1 = new ArrayList<>();
        Management management2 = new Management();
        management2.setId(1L);
        management2.setContactPersonnel("李红");
        managementList1.add(management2);
        Management management3 = new Management();
        management3.setId(1L);
        management3.setContactPersonnel("赵柳");
        managementList1.add(management3);

        List<Management> managementList2 = new ArrayList<>();
        Management management4 = new Management();
        management4.setId(1L);
        management4.setContactPersonnel("线索跟进");
        managementList2.add(management4);
        Management management5 = new Management();
        management5.setId(1L);
        management5.setContactPersonnel("电话跟进");
        managementList2.add(management5);

        followFormBoxDto.setManagementList(managementList0);
        followFormBoxDto.setManagementList1(managementList);
        followFormBoxDto.setManagementList2(managementList1);
        followFormBoxDto.setManagementList3(managementList2);

        Map<String, Object> map = new HashMap<>();
        map.put("followFormBox",followFormBoxDto);

        return Result.success(map);

    }


    @ApiOperation("跟进页面删除")
    @DeleteMapping("/follow/{id}")
    public Result delete(@PathVariable("id")Long id){

        followFormService.removeById(id);
        return Result.success();


    }
    @ApiOperation("线索页面批量删除")
    @DeleteMapping("/deletion")
    public Result deletion(@RequestBody List<FollowFormDto> clueDtos){
        for (FollowFormDto followFormDto : clueDtos) {
            followFormService.removeById(followFormDto.getId());
        }

        return Result.success();
    }




}
