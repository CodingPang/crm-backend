package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Equivalence;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.Contact;
import com.greatgump.crm.entity.Offer;
import com.greatgump.crm.entity.OfferDetails;
import com.greatgump.crm.entity.Product;
import com.greatgump.crm.service.CustomerService;
import com.greatgump.crm.service.OfferDetailsService;
import com.greatgump.crm.service.ProductService;
import com.greatgump.crm.service.UserService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "AAA新增报价后跳出的商品页面-l")
@RestController
public class OfferDetailsController {
    @Autowired
    private OfferDetailsService offerDetailsService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;



    @ApiOperation("这是关联客户下拉框，会返回客户名称及id")
    @GetMapping("/crm/offer_details/listcustmoer")
    public Result<List<LuoDto2>> listCustomer(){
       return Result.success(customerService.queryName());
    }

    @ApiOperation("这是报价人下拉框，会返回报价人名称及id")
    @GetMapping("/crm/offer_details/listuser")
    public  Result<List<UserDto0>> listUser(){
        return Result.success(userService.getName());
    }
    @ApiOperation("联系人的下拉框，需提供客户id")
    @GetMapping("/crm/offer_details/phone")
    public Result<List<ContactNameDto>> listPhone(Long id){
        return Result.success(customerService.queryPhone(id));
    }
    @ApiOperation("修改报价页面列表，需提供页面参数")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/crm/offer_details/list/{current}/{size}")
    public Result<List<OfferDetails>> list(@PathVariable("current")int current,@PathVariable("size")int size){
        Page<OfferDetails> offerPage = new Page(current,size);
        Page<OfferDetails> offerInfo = offerDetailsService.page(offerPage);
        return Result.success(offerPage.getRecords(),offerInfo.getTotal());
    }

    @ApiOperation("修改报价页面删除")
    @DeleteMapping("/crm/offer_details/delete")
    public Result delete(Long id){

        boolean flag = offerDetailsService.removeById(id);
        return Result.judge(flag);
    }

    @ApiOperation("修改报价页面批量删除")
    @DeleteMapping("/crm/offer_details/deletes")
    public Result deletes(List<OfferDetails> offerDetails){
        boolean flag =offerDetailsService.removeBatchByIds(offerDetails);
        return Result.judge(flag);
    }

//    @ApiOperation("修改报价页面报价记录条数")
//    @GetMapping()
//    public R listCount(){
//        return R.ok().put("报价记录条数",offerDetailsService.count());
//    }
    @ApiOperation("这是商品的总个数")
    @GetMapping("/crm/offer_details/countproduct")
    public Result productCount(){
        return Result.success(offerDetailsService.countNumber());
    }
    @ApiOperation("这是总金额")
    @GetMapping("/crm/offer_details/totalmoney")
    public Result totalMoney(){
        return Result.success(offerDetailsService.totalMoney());
    }
//    @ApiOperation("提交报价后的保存")
//    @PutMapping("/crm/offer_details/add")
//    public Result add(OfferDetails offerDetails){
//        boolean flag =offerDetailsService.save(offerDetails);
//        return Result.judge(flag);
//    }
    @ApiOperation("这是报价商品页面")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/crm/offer_details/listproduct/{current}/{size}/{customerId}")
    public Result listProduct(@PathVariable("customerId") int customerId,@PathVariable("current") int current, @PathVariable("size") int size){
        Page<OfferDetails> offerPage = new Page(current,size);

        QueryWrapper<OfferDetails> wrapper = new QueryWrapper<>();
        wrapper.eq("company" , customerId);
        wrapper.isNull("remake");
        Page<OfferDetails> page = offerDetailsService.page(offerPage, wrapper);
        return Result.success(page.getRecords(),page.getTotal());
    }
    @ApiOperation("添加商品的列表-所有商品")
    @GetMapping("/crm/offer_details/listallproduct/{current}/{size}")
    public Result<List<ProductListDto>> listAllProduct(@PathVariable("current")int current,@PathVariable("size")int size){
        Page<ProductListDto> offerListDtoPage = new Page<>(current,size);
        Page<ProductListDto> productListDtoPage = productService.listAll(offerListDtoPage);
//        System.out.println("===================>"+offerListDtoPage1.getRecords());
        return Result.success(productListDtoPage.getRecords(),productListDtoPage.getTotal());
    }

    @ApiOperation("所有商品页面的添加按钮，注意传当前公司company的Id")
    @PostMapping("/crm/offer_details/addincus")
    public Result addInCus(@RequestBody List<ProductListDto> productListDtos){
        List<OfferDetails> offerDetails = new ArrayList<>();
        for(ProductListDto productListDto : productListDtos){
            OfferDetails offerDetails1 = new OfferDetails();
            BeanUtils.copyProperties(productListDto,offerDetails1);
            offerDetails.add(offerDetails1);
        }
        return Result.success(offerDetailsService.saveBatch(offerDetails));
    }
//    @ApiOperation("提交报价")
//    @PostMapping("/crm/offer_details/addinoffer")
//    public Result addproduct(@RequestBody List<OfferDetails> offerDetails){
//        for (OfferDetails offerDetail:offerDetails) {
//                    offerDetail.setRemake(1L);
//        }
//      return   Result.success(offerDetailsService.saveBatch(offerDetails));
//    }
//







}
