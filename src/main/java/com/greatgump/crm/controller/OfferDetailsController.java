package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Equivalence;
import com.greatgump.crm.dto.LuoDto1;
import com.greatgump.crm.dto.LuoDto2;
import com.greatgump.crm.entity.Contact;
import com.greatgump.crm.entity.Offer;
import com.greatgump.crm.entity.OfferDetails;
import com.greatgump.crm.entity.Product;
import com.greatgump.crm.service.CustomerService;
import com.greatgump.crm.service.OfferDetailsService;
import com.greatgump.crm.service.ProductService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "新增报价后跳出的商品页面-l")
@RestController
public class OfferDetailsController {
    @Autowired
    private OfferDetailsService offerDetailsService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    @ApiOperation("这是关联客户下拉框，会返回客户名称及id")
    @GetMapping("/crm/offer_details/listcustmoer")
    public Result<List<LuoDto2>> listCustomer(){
       return Result.success(customerService.queryName());
    }

    @ApiOperation("联系人的下拉框，需提供客户id")
    @GetMapping("/crm/offer_details/phone")
    public Result<List<String>> listPhoe(){
        return Result.success(customerService.queryPhone());
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
    @ApiOperation("提交报价后的保存")
    @PutMapping("/crm/offer_details/add")
    public Result add(OfferDetails offerDetails){
        boolean flag =offerDetailsService.save(offerDetails);
        return Result.judge(flag);
    }
    @ApiOperation("这是报价商品页面")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/crm/offer_details/listproduct/{current}/{size}")
    public Result<List<LuoDto1>>listProduct(@PathVariable("current") int current, @PathVariable("size") int size){
//        Page<Product> contactPage = new Page(current,size);
        return Result.success(productService.listIneed(current,size));
    }
//







}
