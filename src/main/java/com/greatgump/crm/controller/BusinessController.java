package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.BusinessDto;
import com.greatgump.crm.dto.UserDto;
import com.greatgump.crm.entity.*;
import com.greatgump.crm.service.BusinessService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 商机管理 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "商机模块说明")
@RestController
@RequestMapping("/crm/business")
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @ApiOperation("获取所有商机信息")
    @GetMapping("/businesss/{current}/{size}")
    public Result<BusinessDto> getAllCustomer(@PathVariable("current") int current,
                                              @PathVariable("size") int size) {
        Page<Customer> customerPage = new Page<>(current, size);



        BusinessDto businessDto = new BusinessDto("上海大华科技有限公司", "采购需求", "方案展示", "15条",
                new Date(System.currentTimeMillis())
                , 1);
        return Result.success(businessDto, 5L);
    }

    @ApiOperation("预新增商机信息")
    @GetMapping("/pre")
    public Result<Map<String, Object>> preAdd() {
        // 1、商机归属人（销售）
        UserDto userDto01 = new UserDto();// 商机归属人（销售）
        userDto01.setId(1L);
        userDto01.setUsername("张三");

        UserDto userDto02 = new UserDto();// 商机归属人（销售）
        userDto02.setId(2L);
        userDto02.setUsername("LS");

        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(userDto01);
        userDtoList.add(userDto02);

//        TODO 商机来源、商机阶段、关联的客户



        Map<String, Object> map = new HashMap<>();
        map.put("商机归属人", userDtoList);


        // 返回封装的结果
        return Result.success(map, 6L);

    }

    @ApiOperation("新增商机信息")
    @PostMapping("/{businessDto}")
    public Result saveBusiness(@PathVariable("businessDto") BusinessDto businessDto) {



        return null;
    }


}