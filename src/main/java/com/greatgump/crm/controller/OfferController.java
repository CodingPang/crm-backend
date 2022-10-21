package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.Contact;
import com.greatgump.crm.entity.Offer;
import com.greatgump.crm.entity.OfferDetails;
import com.greatgump.crm.service.ContactService;
import com.greatgump.crm.service.OfferDetailsService;
import com.greatgump.crm.service.OfferService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
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
@Api(tags = "AAA报价管理主页面-l")
@RestController
public class OfferController {
    @Autowired
    private OfferService offerService;
    @Autowired
    private OfferDetailsService offerDetailsService;
    @Autowired
    private ContactService contactService;




    public Result<List<Offer>> list(@PathVariable("current")int current,@PathVariable("size")int size){
        Page<Offer> offerPage = new Page(current,size);
        Page<Offer> offerInfo = offerService.page(offerPage);
        return Result.success(offerInfo.getRecords(),offerInfo.getTotal());
    }
    @ApiOperation("报价管理页面主界面列表，需提供页面参数")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/crm/offer/list/{current}/{size}")
    public Result<List<OfferListDto>> list1(@PathVariable("current")int current,@PathVariable("size")int size){
        Page<OfferListDto> offerListDtoPage = new Page<>(current,size);
        Page<OfferListDto> offerListDtoPage1 = offerService.listIneed(offerListDtoPage);
        System.out.println("===================>"+offerListDtoPage1.getRecords());
        return Result.success(offerListDtoPage1.getRecords(),offerListDtoPage1.getTotal());
    }

    public Result addDto(@RequestBody OfferDto offerDto, @RequestParam(required = false) List<OfferDetailsDto> offerDetailsDtos){
        System.out.println("========>"+offerDto);
        Offer offer = new Offer();
        List<OfferDetails> offerDetails = new ArrayList<>();
        BeanUtils.copyProperties(offerDto,offer);
        if (offerDetailsDtos!=null) {
            BeanUtils.copyProperties(offerDetailsDtos, offerDetails);
        }
        Date date = new Date();
        String str = RandomStringUtils.randomAlphabetic(5);
        offer.setCreationDate(date);
        offer.setOddNum("QU20220512"+str);
        System.out.println("===================>OOOOOOOOFFFFFFEEEEERRRRR"+offer);
        offerService.save(offer);
        boolean flag = offerService.save(offer);
        boolean flag1 = offerDetailsService.saveBatch(offerDetails);
        return Result.judge(flag&&flag1);
    }
    @ApiOperation("报价管理页面增加")
    @PostMapping("/crm/offer/add")
    public Result addDto1(@RequestBody OfferBigDto offerBigDto){
        System.out.println("====>"+offerBigDto);
        List<OfferDetailsDto> offerDetailsDtos = offerBigDto.getOfferDetailsDtos();
        System.out.println("======>"+offerDetailsDtos);
        Offer offer = new Offer();
        List<OfferDetails> offerDetails = new ArrayList<>();
        BeanUtils.copyProperties(offerBigDto,offer);
        if (offerDetailsDtos!=null) {
            for(OfferDetailsDto offerDetailsDto : offerDetailsDtos){
                OfferDetails offerDetails1 = new OfferDetails();
                BeanUtils.copyProperties(offerDetailsDto,offerDetails1);
                offerDetails.add(offerDetails1);
            }
            System.out.println("======>"+offerDetails);
        }
        Date date = new Date();
        String str = RandomStringUtils.randomAlphabetic(5);
        offer.setCreationDate(date);
        offer.setOddNum("QU20220512"+str);
        System.out.println("===================>OOOOOOOOFFFFFFEEEEERRRRR"+offer);
        boolean flag = offerService.save(offer);
        boolean flag1 = offerDetailsService.saveBatch(offerDetails);
        return Result.judge(flag&&flag1);
    }

//    @ApiOperation("报价管理页面增加")
//    @PostMapping("/crm/offer/add")
//    public Result add(Offer offer){
//        String danhao = "QU20220512"+offer.getId();
//        offer.setOddNum(danhao);
//        Date date= new Date();
//        offer.setCreationDate(date);
//        boolean flag = offerService.save(offer);
//        return Result.judge(flag);
//    }

    @ApiOperation("报价管理页面删除")
    @DeleteMapping("/crm/offer/delete")
    public Result delete(Long id){
        boolean flag = offerService.removeById(id);
        return Result.judge(flag);
    }

    @ApiOperation("报价管理页面修改")
    @PutMapping("/crm/offer/update")
    public Result update(@RequestBody OfferBigDto offerBigDto){
        System.out.println("====>"+offerBigDto);
        List<OfferDetailsDto> offerDetailsDtos = offerBigDto.getOfferDetailsDtos();
        System.out.println("======>"+offerDetailsDtos);
        Offer offer = new Offer();
        List<OfferDetails> offerDetails = new ArrayList<>();
        BeanUtils.copyProperties(offerBigDto,offer);
        if (offerDetailsDtos!=null) {
            for(OfferDetailsDto offerDetailsDto : offerDetailsDtos){
                OfferDetails offerDetails1 = new OfferDetails();
                BeanUtils.copyProperties(offerDetailsDto,offerDetails1);
                offerDetails.add(offerDetails1);
            }
            System.out.println("======>"+offerDetails);
        }
        Date date = new Date();
        offer.setCreationDate(date);
        System.out.println("===================>OOOOOOOOFFFFFFEEEEERRRRR"+offer);
        boolean flag = offerService.updateById(offer);
        boolean flag1 = offerDetailsService.saveBatch(offerDetails);
        return Result.judge(flag&&flag1);
    }
    @ApiOperation("报价管理搜索")
    @PostMapping("/crm/offer/search")
    public Result<List<OfferListDto>> search(@RequestBody OfferSearchDto offerSearchDto){
        System.out.println("offersearch===========>"+offerSearchDto);
        List<OfferListDto> offerListDtoPage= offerService.searchList(offerSearchDto);
        Long count = Long.valueOf(offerService.countList(offerSearchDto));
        return Result.success(offerListDtoPage,count);
    }
    @ApiOperation("联系人信息")
    @PostMapping("/crm/offer/list/call")
    public Result<Contact> listCall(Integer id){
        System.out.println("listCall====>"+id);
        return Result.success(contactService.queryOne(id));
    }

    @ApiOperation("报价详情的明细，传公司id")
    @PostMapping("/crm/offer/searchdetails")
    public Result<List<OfferDetails>> listOffer(Long id){
        QueryWrapper<OfferDetails> wrapper = new QueryWrapper<>();
        wrapper.eq("company" , id);
        List<OfferDetails> offerDetails = offerDetailsService.list(wrapper);
        return Result.success(offerDetails);
    }



    @ApiOperation("管理页面修改按钮")
    @GetMapping("/crm/offer/pre_update")
    private Result<Offer> preUpdate(Long id){
        return Result.success(offerService.getById(id));
    }





}
