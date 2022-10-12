package com.greatgump.crm.controller;

import com.greatgump.crm.common.R;
import com.greatgump.crm.entity.Offer;
import com.greatgump.crm.service.OfferService;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@RestController
public class OfferController {
    @Autowired
    private OfferService offerService;

    @ApiOperation("报价管理页面主界面列表")
    @GetMapping("/crm/offer/list")
    public R list(){
        return R.ok().put("offerlist",offerService.list());
    }

    @ApiOperation("报价管理页面增加")
    @PostMapping("/crm/offer/add")
    public R add(Offer offer){
        String danhao = "QU20220512"+offer.getId();
        offer.setOddNum(danhao);
        Date date= new Date();
        offer.setCreationDate(date);
        offerService.save(offer);
        return R.ok().put("offeradd",offer);
    }

    @ApiOperation("报价管理页面删除")
    @DeleteMapping("/crm/offer/delete")
    public R delete(Long id){
        offerService.removeById(id);
        return R.ok().put("offerdelete",id);
    }

    @ApiOperation("报价管理页面修改")
    @PutMapping("/crm/offer/update")
    private R update(Offer offer){

        Date date= new Date();
        offer.setCreationDate(date);
        offerService.updateById(offer);
        return R.ok().put("offerupdate",offer);
    }

    @ApiOperation("报价管理页面修改按钮")
    @GetMapping("/crm/offer/pre_update")
    private R preUpdate(Long id){
        return R.ok().put("offer_preUpdate",offerService.getById(id));
    }

}
