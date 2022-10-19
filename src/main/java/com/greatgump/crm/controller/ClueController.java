package com.greatgump.crm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.dto.clue.CluePreEditDto;
import com.greatgump.crm.dto.power.UserDto;
import com.greatgump.crm.entity.*;
import com.greatgump.crm.service.ClueService;

import com.greatgump.crm.service.FollowFormService;

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





    @ApiOperation("获取所有线索的信息")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current", value = "当前页数", required = true), @ApiImplicitParam(name = "size", value = "每页的条数", required = true)})
    @GetMapping("/queryAllLoans/{current}/{size}")
    public Result<List<Clue>> queryAllLoans(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {

        Page<Clue> cluePage = new Page(current,size);
        Page<Clue> clueInfo = clueService.page(cluePage);
        return Result.success(cluePage.getRecords(),clueInfo.getTotal());
//        ClueDto clueDto = new ClueDto();
//
//// 1、所有客户对象(客户名称)
//        CustomerDto customer01 = new CustomerDto();
//        customer01.setId(1L);
//        customer01.setCustomerName("xxx公司");
//
//        CustomerDto customer02 = new CustomerDto();
//        customer02.setId(1L);
//        customer02.setCustomerName("xxx公司");
//
//        List<CustomerDto> customerList = new ArrayList<>();
//        customerList.add(customer01);
//        customerList.add(customer02);
//
//        // 查询出归属人员(所有的归属人员应该都是user)
//        UserDto personnel01 = new UserDto();
//        personnel01.setId(1L);
//        personnel01.setUsername("zs");
//
//        UserDto personnel02 = new UserDto();
//        personnel02.setId(2L);
//        personnel02.setUsername("ls");
//  /*List<UserDto> userList = new ArrayList<>();
//  userList.add(personnel01);
//  userList.add(personnel02);*/
//
//
//        // 查询出联系人(所有的联系人应该都是UserDto)
//        UserDto lxr01 = new UserDto();
//        lxr01.setId(1L);
//        lxr01.setUsername("zs");
//
//        UserDto lxr02 = new UserDto();
//        lxr01.setId(2L);
//        lxr01.setUsername("ls");
//        List<UserDto> lxrList = new ArrayList<>();
//        lxrList.add(lxr01);
//        lxrList.add(lxr02);
//
//        // 联系号码
//        String phone01 = "17715214455";
//        String phone02 = "17715214456";
//
//        // 最后跟进
//        // System.currentTimeMillis() 获取当前系统的毫秒数
//        Date date01 = new Date(System.currentTimeMillis());
//        Date date02 = new Date(System.currentTimeMillis() + 1);
//
//        // 未跟进天数
//        Integer notFollowDays01 = 6;
//        Integer notFollowDays02 = 3;
//
//        // 将数据封装进ClueQueryDto
//        ClueQueryDto clueQueryDto01 = new ClueQueryDto();
//        clueQueryDto01.setCustomerDto(customer01);
//        clueQueryDto01.setPersonnel(personnel01);
//        clueQueryDto01.setContacts(lxr01);
//        clueQueryDto01.setPhone(phone01);
//        clueQueryDto01.setLastFollow(date01);
//        clueQueryDto01.setNotFollowDays(notFollowDays02);
//
//        ClueQueryDto clueQueryDto02 = new ClueQueryDto();
//        clueQueryDto02.setCustomerDto(customer01);
//        clueQueryDto02.setPersonnel(personnel01);
//        clueQueryDto02.setContacts(lxr01);
//        clueQueryDto02.setPhone(phone01);
//        clueQueryDto02.setLastFollow(date01);
//        clueQueryDto02.setNotFollowDays(notFollowDays02);
//
//        List<ClueQueryDto> clueQueryDtos = new ArrayList<>();
//        clueQueryDtos.add(clueQueryDto01);
//        clueQueryDtos.add(clueQueryDto02);
//
//        // 通过Result工具类封装给前端解析
//        return Result.success(clueQueryDtos, 2L);

    }


    @ApiOperation("线索信息预增加操作")
    @GetMapping("/preAdd")
    public Result<ClueBoxDto> preAdd() {

        ClueBoxDto clueBoxDto = new ClueBoxDto();
        // 1、线索归属
        List<Clue> clueList = new ArrayList<>();
        Clue clue = new Clue();
        clue.setId(1L);
        clue.setPersonnel("zs");
        clueList.add(clue);
        Clue clue1 = new Clue();
        clue1.setId(2L);
        clue1.setPersonnel("ls");
        clueList.add(clue1);

        // 2、线索来源
        List<FollowForm> sourceList = new ArrayList<>();
        FollowForm followForm = new FollowForm();
        followForm.setId(1L);
        followForm.setFollowSource("主动来电");
        sourceList.add(followForm);
        FollowForm followForm1 = new FollowForm();
        followForm1.setId(2L);
        followForm1.setFollowSource("客户介绍");
        sourceList.add(followForm1);

        // 3、线索状态
        List<FollowForm> statusList = new ArrayList<>();
        FollowForm followForm01 = new FollowForm();
        followForm01.setId(1L);
        followForm01.setFollowType("1");
        statusList.add(followForm01);
        FollowForm followForm02 = new FollowForm();
        followForm02.setId(1L);
        followForm02.setFollowType("2");
        statusList.add(followForm02);


        clueBoxDto.setSourceList(sourceList);
        clueBoxDto.setClueList(clueList);
        clueBoxDto.setStatusList(statusList);

//        Map<String, Object> map = new HashMap<>();
//        map.put("cluebox", clueBoxDto);


        return Result.success(clueBoxDto);



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


/*  //关联客户
  List<Customer> customerList = new ArrayList<>();
  Customer customer01 = new Customer();
  customer01.setId(1L);
  customer01.setCustomerName("张三");
  Customer customer02 = new Customer();
  customer02.setId(2L);
  customer02.setCustomerName("李四");
  Customer customer03 = new Customer();
  customer03.setId(3L);
  customer03.setCustomerName("赵柳");*/

    }


/* @ApiOperation("线索信息增加")
 @PostMapping("/preAdd")
 public Result saveClue(@RequestBody ){

 }*/
// @ApiOperation("联系信息")
// @GetMapping("/contactAdd")
// public Result<Map<String, Object>> contactAdd() {
//  // 1、联系人
//  Foll user01 = new UserDto();



    @ApiOperation("新增操作")
    @PostMapping("/preAddcontact")
    public Result<Clue> preAddcontact(@RequestBody ClueReceiveDto clueReceiveDto) {

         boolean b = clueService.saveClue(clueReceiveDto);

        return Result.judge(b);
//        FollowFormDto followFormDto = new FollowFormDto();
//        followFormDto.setContactss("zz");
//        followFormDto.setPhone("123323432");
//        followFormDto.setQq("54546566");
//        followFormDto.setId(1L);
//        followFormDto.setWechat("324342343");
//        followFormDto.setEMail("123@126.com");
//        followFormDto.setDeptId("1");

//        Map<String, Object> map = new HashMap<>();
//        map.put("followFormDto", followFormDto);



    }


    @ApiOperation("预编辑")
    @GetMapping("/crm/clue/preUpdate/{id}")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "id", value = "要查询的这条记录的主键", required = true)})
    public Result<CluePreEditDto> preEdit(@PathVariable("id") Integer id){
        // 1、根据id查询这条数据在线索表的记录
        CluePreEditDto cluePreEditDto = clueService.queryOneClue(id);
        return null;
    }

    @ApiOperation("主页面编辑")
    @PutMapping("/crm/clue/update")
    public Result update(@RequestBody ClueReceiveDto clueReceiveDto) {

        boolean c = clueService.update(clueReceiveDto) ;
        return Result.judge(c);
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
        boolean s = clueService.removeById(id);

        return Result.judge(s);

    }


    @ApiOperation("线索页面批量删除")
    @DeleteMapping("/deletion")
    public Result deletion(@RequestBody List<ClueReceiveDto> clueReceiveDtos) {
        for (ClueReceiveDto clueReceiveDto : clueReceiveDtos) {
            clueService.removeById(clueReceiveDto.getId());
        }
        return Result.success();
    }

}