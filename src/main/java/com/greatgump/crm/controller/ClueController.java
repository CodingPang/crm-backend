package com.greatgump.crm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
  // 1、线索归属
  UserDto user01 = new UserDto();
  user01.setId(1L);
  user01.setUsername("张三");

  UserDto user02 = new UserDto();
  user02.setId(2L);
  user02.setUsername("李四");

  List<UserDto> userList = new ArrayList<>();
  userList.add(user01);
  userList.add(user02);

  // 2、线索来源
  Source source01 = new Source();
  source01.setId(1L);
  source01.setName("主动来电");

  Source source02 = new Source();
  source02.setId(2L);
  source02.setName("客户介绍");

  List<Source> sourceList = new ArrayList<>();
  sourceList.add(source01);
  sourceList.add(source02);

  // 3、线索状态
  Clue clue01 = new Clue();
  clue01.setId(1L);
  clue01.setUsername("初步意向");

  Clue clue02 = new Clue();
  clue02.setId(2L);
  clue02.setUsername("下次邀约");

  Clue clue03 = new Clue();
  clue03.setId(3L);
  clue03.setUsername("已转客户");

  List<Clue> clueList = new ArrayList<>();
  clueList.add(clue01);
  clueList.add(clue02);
  clueList.add(clue03);

/*  List<Business> businessList = new ArrayList<>();
  Business business01 = new Business();
  business01.setId(1L);
  business01.setBussinessStage(1L);
  Business business02 = new Business();
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


  ClueBoxDto clueBoxDto = new ClueBoxDto(userList, sourceList, clueList);
  Map<String, Object> map = new HashMap<>();
  map.put("cluebox", clueBoxDto);
  // 返回封装的结果
  return Result.success(map,3L);

 }


/* @ApiOperation("线索信息增加")
 @PostMapping("/preAdd")
 public Result saveClue(@RequestBody ){

 }*/










}