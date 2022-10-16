package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.BusinessDto;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.service.ManagementService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 * 跟进管理 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "跟进模块说明")
@RestController
@RequestMapping("/crm/management")
public class ManagementController {
    @Autowired
    private ManagementService managementService;
    public Result<BusinessDto> getAllCustomer(@PathVariable("current") int current,
                                              @PathVariable("size") int size) {
        Page<Customer> customerPage = new Page<>(current, size);


//        BusinessDto businessDto = new BusinessDto("2020-03-23", "与客户沟通报价事宜", "上海大华有限公司", "李洪", new Date(), 0);
        return Result.success(null, 5L);
    }


    }
