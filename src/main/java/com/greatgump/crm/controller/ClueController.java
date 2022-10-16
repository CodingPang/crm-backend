package com.greatgump.crm.controller;



import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.*;
import com.greatgump.crm.service.ClueService;

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

 @ApiOperation("获取所有线索的信息")
 @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
 @GetMapping("/queryAllLoans/{current}/{size}")
 public Result<List<ClueQueryDto>> queryAllLoans(@PathVariable("current") Integer current,@PathVariable("size") Integer size){
   ClueDto clueDto = new ClueDto();

// 1、所有客户对象(客户名称)
  CustomerDto customer01 = new CustomerDto();
  customer01.setId(1L);
  customer01.setCustomerName("xxx公司");

  CustomerDto customer02 = new CustomerDto();
  customer02.setId(1L);
  customer02.setCustomerName("xxx公司");

  List<CustomerDto> customerList = new ArrayList<>();
  customerList.add(customer01);
  customerList.add(customer02);

  // 查询出归属人员(所有的归属人员应该都是user)
 UserDto personnel01 = new UserDto();
 personnel01.setId(1L);
 personnel01.setUsername("zs");

  UserDto personnel02 = new UserDto();
  personnel02.setId(2L);
  personnel02.setUsername("ls");
  /*List<UserDto> userList = new ArrayList<>();
  userList.add(personnel01);
  userList.add(personnel02);*/


  // 查询出联系人(所有的联系人应该都是UserDto)
  UserDto lxr01 = new UserDto();
  lxr01.setId(1L);
  lxr01.setUsername("zs");

  UserDto lxr02 = new UserDto();
  lxr01.setId(2L);
  lxr01.setUsername("ls");
  List<UserDto> lxrList = new ArrayList<>();
  lxrList.add(lxr01);
  lxrList.add(lxr02);

  // 联系号码
  String phone01 = "17715214455";
  String phone02 = "17715214456";

  // 最后跟进
     // System.currentTimeMillis() 获取当前系统的毫秒数
     Date date01 = new Date(System.currentTimeMillis());
     Date date02 = new Date(System.currentTimeMillis() + 1);

     // 未跟进天数
     Integer notFollowDays01 = 6;
     Integer notFollowDays02 = 3;

     // 将数据封装进ClueQueryDto
  ClueQueryDto clueQueryDto01 = new ClueQueryDto();
  clueQueryDto01.setCustomerDto(customer01);
  clueQueryDto01.setPersonnel(personnel01);
  clueQueryDto01.setContacts(lxr01);
  clueQueryDto01.setPhone(phone01);
  clueQueryDto01.setLastFollow(date01);
  clueQueryDto01.setNotFollowDays(notFollowDays02);

  ClueQueryDto clueQueryDto02 = new ClueQueryDto();
  clueQueryDto02.setCustomerDto(customer01);
  clueQueryDto02.setPersonnel(personnel01);
  clueQueryDto02.setContacts(lxr01);
  clueQueryDto02.setPhone(phone01);
  clueQueryDto02.setLastFollow(date01);
  clueQueryDto02.setNotFollowDays(notFollowDays02);

  List<ClueQueryDto> clueQueryDtos = new ArrayList<>();
  clueQueryDtos.add(clueQueryDto01);
  clueQueryDtos.add(clueQueryDto02);

  // 通过Result工具类封装给前端解析
  return Result.success(clueQueryDtos, 2L);

 }


 @ApiOperation("线索信息预增加操作")
 @GetMapping("/preAdd")
 public Result<Map<String, Object>> preAdd() {

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

     Map<String, Object> map = new HashMap<>();
     map.put("cluebox",clueBoxDto);


     return Result.success(map);



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





     @ApiOperation("线索联系信息预增加操作")
     @GetMapping("/preAddcontact")
     public Result<Map<String, Object>> preAddcontact() {
         FollowFormDto followFormDto = new FollowFormDto();
         followFormDto.setContactss("zz");
         followFormDto.setPhone("123323432");
         followFormDto.setQq("54546566");
         followFormDto.setId(1L);
         followFormDto.setWechat("324342343");
         followFormDto.setEMail("123@126.com");
         followFormDto.setDeptId("1");

         Map<String, Object> map = new HashMap<>();
         map.put("followFormDto",followFormDto);
         return Result.success(map);



     }
    @ApiOperation("线索管理页面修改")
    @PutMapping("/modify/{id}")
    public Result<ClueDto> update(@PathVariable("id")Long id){



        Clue clue = new Clue();
        clue.setId(1L);
        clue.setPersonnel("zs");

        FollowForm followForm = new FollowForm();
        followForm.setId(1L);
        followForm.setFollowSource("客户介绍");

        FollowForm followForm1 = new FollowForm();
        followForm1.setId(1L);
        followForm1.setStatus("1");

         String username = "zs";
         String  customerNeeds = "客户需求";

         ClueDto clueDto = new ClueDto();
         clueDto.setClue(clue);
         clueDto.setSource(followForm);
         clueDto.setStatus(followForm1);
         clueDto.setUsername(username);
         clueDto.setCustomerNeeds(customerNeeds);

         return Result.success(clueDto);



        }
        @ApiOperation("线索联系信息修改")
        @PutMapping("/ contact/{id}")
        public Result<FollowFormDto> updateContact(@PathVariable("id")Long id){
            FollowFormDto followFormDto = new FollowFormDto();

            String contactss = "ls";
            String eMail = "123421@126.com";
            String phone = "323423432424";
            String qq ="3242442343";
            String deptId = "2";
            String wechat = "343543fdsf";

            followFormDto.setDeptId(deptId);
            followFormDto.setContactss(contactss);
            followFormDto.setQq(qq);
            followFormDto.setWechat(wechat);
            followFormDto.setId(1L);
            followFormDto.setEMail(eMail);
            followFormDto.setPhone(phone);

            return Result.success(followFormDto);




        }
    @ApiOperation("线索页面删除")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id")Long id){

        clueService.removeById(id);
        return Result.success();


    }
    @ApiOperation("线索页面批量删除")
    @DeleteMapping("/deletion")
    public Result deletion(@RequestBody List<ClueDto> clueDtos){
        for (ClueDto clueDto : clueDtos) {
            clueService.removeById(clueDto.getId());
        }

        return Result.success();
    }

}