package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.common.R;
import com.greatgump.crm.entity.Contact;
import com.greatgump.crm.entity.Offer;
import com.greatgump.crm.service.OfferService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "报价管理主页面-l")
@RestController
public class OfferController {
    @Autowired
    private OfferService offerService;

    @ApiOperation("报价管理页面主界面列表，需提供页面参数")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/crm/offer/list/{current}/{size}")
    public Result<List<Offer>> list(@PathVariable("current")int current,@PathVariable("size")int size){
        Page<Offer> offerPage = new Page(current,size);
        Page<Offer> offerInfo = offerService.page(offerPage);
        return Result.success(offerPage.getRecords(),offerInfo.getTotal());
    }

    @ApiOperation("报价管理页面增加")
    @PostMapping("/crm/offer/add")
    public Result add(Offer offer){
        String danhao = "QU20220512"+offer.getId();
        offer.setOddNum(danhao);
        Date date= new Date();
        offer.setCreationDate(date);
        boolean flag = offerService.save(offer);
        return Result.judge(flag);
    }

    @ApiOperation("报价管理页面删除")
    @DeleteMapping("/crm/offer/delete")
    public Result delete(Long id){
        boolean flag = offerService.removeById(id);
        return Result.judge(flag);
    }

    @ApiOperation("报价管理页面修改")
    @PutMapping("/crm/offer/update")
    private Result update(Offer offer){

        Date date= new Date();
        offer.setCreationDate(date);
        boolean flag = offerService.updateById(offer);
        return Result.judge(flag);
    }

    @ApiOperation("报价管理页面修改按钮")
    @GetMapping("/crm/offer/pre_update")
    private Result<Offer> preUpdate(Long id){
        return Result.success(offerService.getById(id));
    }

}
