package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.OfferDetailsDto;
import com.greatgump.crm.dto.OfferDto;
import com.greatgump.crm.dto.OfferListDto;
import com.greatgump.crm.dto.OrderContextDto;
import com.greatgump.crm.entity.Offer;
import com.greatgump.crm.entity.OfferDetails;
import com.greatgump.crm.entity.Ordercontext;
import com.greatgump.crm.service.OfferDetailsService;
import com.greatgump.crm.service.OrdercontextService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@RestController
public class OrdercontextController {
    @Autowired
    private OrdercontextService ordercontextService;
    @Autowired
    private OfferDetailsService offerDetailsService;


    @ApiOperation("报价管理页面增加")
    @PostMapping("/crm/ordercontext/add")
    public Result addDto(@RequestBody Ordercontext ordercontext, @RequestParam(required = false) List<OfferDetails> offerDetails){
        boolean flag = ordercontextService.save(ordercontext);
        boolean flag1 = offerDetailsService.saveBatch(offerDetails);
        return Result.judge(flag&&flag1);
    }
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @ApiOperation("展示合同")
    @GetMapping("/crm/ordercontext/list/{current}/{size}")
    public Result<List<OrderContextDto>> list(@PathVariable("current")int current,@PathVariable("size")int size){
        Page<OrderContextDto> offerListDtoPage = new Page<>(current,size);
        Page<OrderContextDto> offerListDtoPage1 = ordercontextService.listIneed(offerListDtoPage);
        System.out.println("===================>"+offerListDtoPage1.getRecords());
        return Result.success(offerListDtoPage1.getRecords(),offerListDtoPage1.getTotal());
    }

}
