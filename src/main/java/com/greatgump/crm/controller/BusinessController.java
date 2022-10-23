package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.*;
import com.greatgump.crm.service.*;
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
public class BusinessController {
    @Autowired
    private FollowFormService followFormService;
    @Autowired
    private FollowService followService;

    @Autowired
    private BusinessService businessService;
    @ApiOperation("主页面的商机信息")
    @GetMapping("/crm/business/list/{current}/{size}")
    public Result<List> list(@PathVariable("current")int current,@PathVariable("size")int size){
        try {
            List<BusinessDto> businessDtos = this.businessService.queryAllBusiness(current, size);
            System.out.println(businessDtos);
            Result<List> success =Result.success(businessDtos);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("查询失败");
        }
    }
    @ApiOperation("商机来源")
    @PostMapping("/crm/business/origin")
    public Result<List> queryBusinessOrigin(){
        try {
            List<BusinessOrigin> list = this.businessService.queryBusinessOrigin();
            Result<List> success = Result.success(list);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("查询失败");
        }
    }
    @ApiOperation("商机阶段")
    @PostMapping("/crm/business/stage")
    public Result<List> queryBusinessStage(){
        try {
            List<BusinessStage> list = this.businessService.queryBusinessStage();

            Result<List> success = Result.success(list);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("查询失败");
        }
    }
    @ApiOperation("商机关联客户")
    @PostMapping("/crm/business/relation")
    public Result<List> queryBusinessCustomerRelation(){
        try {
            List<Customer1Dto> list = this.businessService.queryAllCustomer();
            Result<List> success =Result.success(list);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("查询失败");
        }
    }
    @ApiOperation("商机归属")
    @PostMapping("/crm/business/ascription")
    public Result<List> queryBusinessCustomerAscription(){
        try {
            List<Customer1Dto> list = this.businessService.queryCustomerAscription();
            Result<List> success = Result.success(list);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("查询失败");
        }
    }

    @ApiOperation("商机信息增加")
    @PostMapping("/crm/business/add")
    public Result addBusiness(@RequestBody BusinessSourceDto businessSourceDto){
        try {
            this.businessService.addBusiness(businessSourceDto);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("添加失败");
        }

    }


    @ApiOperation("主页面商机表单搜索")
    @PostMapping("/crm/business/query")
    public Result<List> queryBusiness(@RequestBody BussinessDictionaryDto businessSourceDto){
        try {
            List<BusinessDto> list=this.businessService.queryBusinessForm(businessSourceDto);
            Result<List> success = Result.success(list);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("查找失败");
        }

    }


    @ApiOperation("主页面的单个删除")
    @DeleteMapping("/crm/business/delete/{id}")
    public Result delete(@PathVariable("id") Long id){
        try {
            this.businessService.deleteBusiness(id);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("删除失败");
        }
    }

    @ApiOperation("主页面批量删除")
    @DeleteMapping("/crm/business/deletes")
    public Result deletes(List<Long> ids){
        try {
            this.businessService.deletesBusiness(ids);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("批量删除失败");
        }
    }
    @ApiOperation("主页面回显编辑内容")
    @GetMapping("/crm/business/pre")
    public Result queryId(Long id){
        try {
            BusinessDto2 businessDto2 = this.businessService.queryId(id);
            return Result.success(businessDto2);
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("回显失败");
        }
    }


    @ApiOperation("主页面编辑")
    @PutMapping("/crm/business/update")
    public Result update(@RequestBody  BusinessSourceDto businessSourceDto){
        try {
            this.businessService.updateBusiness(businessSourceDto);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("编辑失败");
        }
    }


    @ApiOperation("主页面跟进回显")
    @GetMapping("/crm/business/chasingPre")
    public Result queryChasing(Long id){
        try {
            ChasingDto chasingDto = this.businessService.queryChasing(id);
            return Result.success(chasingDto);
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("跟进回显失败");
        }
    }

    @ApiOperation("主页面跟进回显增加")
    @GetMapping("/crm/business/addchasing")
    public Result addChasing(ChasingAddDto chasingAddDto){
        try {
            this.businessService.addChasing(chasingAddDto);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("跟进失败");
        }
    }
    @ApiOperation("点击标题回转显示需求")
    @GetMapping("/crm/business/need")
    public Result<List> queryInformation(String businessTitle){
        try {
            List<BusinessSourceDto> businessSourceDtos = this.businessService.queryInformation(businessTitle);

            //差东西
            Result<List> success = Result.success(businessSourceDtos);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("跟进失败");
        }
    }
    @ApiOperation("概括信息中联系人")
    @GetMapping("/crm/business/people")
    public Result<List> queryPeople(String businessTitle){
        try {
            List<BusinessCustomerDto> businessCustomerDtos = this.businessService.queryPeople(businessTitle);
            Result<List> success = Result.success(businessCustomerDtos);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("跟进失败");
        }
    }

    @ApiOperation("概括信息中跟进记录全部详情")
    @GetMapping("/crm/business/plans")
    public Result<List> queryChasingPlans(String businessTitle){
        try {
            List<FollowDetailsDto> followDetailsDtos = this.businessService.queryChasingPlans(businessTitle);
            Result<List> success = Result.success(followDetailsDtos);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("跟进失败");
        }
    }
    @ApiOperation("概括信息中跟进记录单个详情")
    @GetMapping("/crm/business/plan")
    public Result queryChasingPlan(String userName,Date progressiveTime){
        try {
            FollowDetailsDto followDetailsDto = this.businessService.queryChasingPlan(userName,progressiveTime);
            return Result.success(followDetailsDto);
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("跟进失败");
        }
    }
    @ApiOperation("概括信息中跟进计划全部")
    @GetMapping("/crm/business/follow_plans")
    public Result<List> queryFollowPlans(String businessTitle){
        try {
            List<FollowPlan1Dto> followPlan1Dtos = this.businessService.queryFollowPlan(businessTitle);
            Result<List> success =Result.success(followPlan1Dtos);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("跟进计划查找失败");
        }
    }

    @ApiOperation("概括信息中跟进计划条件查询")
    @GetMapping("/crm/business/follow_plan")
    public Result<List> queryFollowPlan(String title,String planProgress){
        try {
            List<FollowPlan1Dto> followPlan1Dtos = this.businessService.queryFollowPlan1(title,planProgress);
            return Result.success(followPlan1Dtos);
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("跟进计划查找失败");
        }
    }

    @ApiOperation("概括信息中报价计划详情")
    @GetMapping("/crm/business/products")
    public Result<List> queryProductPlan(String businessTitle){
        try {
            List<ProductPlanDto> productPlanDtos = this.businessService.queryProductPlan(businessTitle);
            Result<List> success =Result.success(productPlanDtos);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("请求失败");
        }
    }
    @ApiOperation("概括信息中报价计划详情上方的求总数")
    @GetMapping("/crm/business/product/count")
    public Result queryProductPlanCount(String businessTitle){
        try {
            ProductCountDto productCountDto = this.businessService.queryCount(businessTitle);
            return Result.success(productCountDto);
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("请求失败");
        }
    }
    @ApiOperation("报价计划的单个删除")
    @DeleteMapping("/crm/business/product/delete")
    public Result deleteProduct(int id){
        try {
            this.businessService.deleteProduct(id);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("删除失败");
        }
    }

    @ApiOperation("报价计划批量删除")
    @DeleteMapping("/crm/business/product/deletes")
    public Result deleteProducts(List<Integer> ids){
        try {
            this.businessService.deleteProducts(ids);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("批量删除失败");
        }
    }
    @ApiOperation("概括信息中关联订单详情")
    @GetMapping("/crm/business/order")
    public Result<List> queryOrder(String businessTitle){
        try {
            List<OrderBusinessDto> orderBusinessDtos = this.businessService.queryBusinessOder(businessTitle);
            Result<List> success =Result.success(orderBusinessDtos);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("请求失败");
        }
    }
    @ApiOperation("概括信息中关联订单详情编辑")
    @PutMapping("/crm/business/order/update")
    public Result queryOrderUpdate(Long id){
        try {


            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("请求失败");
        }
    }

    @ApiOperation("概括信息中报价计划详情跟进")
    @GetMapping("/crm/business/order/follow")
    public Result queryOrderFollow(Long id){
        try {
            OrderFollowDto orderFollowDto = this.businessService.addOrderFollow(id);
            return Result.success(orderFollowDto);
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("请求失败");
        }
    }


    @ApiOperation("关联订单的单个删除")
    @DeleteMapping("/crm/business/order/delete")
    public Result deleteOder(Long id){
        try {
            this.businessService.deleteOder(id);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("删除失败");
        }
    }

    @ApiOperation("概括信息中相关附件")
    @GetMapping("/crm/business/enclosure")
    public Result<List> queryEnclosure(String businessTitle){
        try {
            List<UplodeEnclosureDto> uplodeEnclosureDtos = this.businessService.queryEnclosure(businessTitle);
            Result<List> success = Result.success(uplodeEnclosureDtos);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("请求失败");
        }
    }
    @ApiOperation("关联订单的单个删除")
    @DeleteMapping("/crm/business/enclosure/delete")
    public Result deleteUpload(Long id){
        try {
            this.businessService.deleteEnclosure(id);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("删除失败");
        }
    }
    @ApiOperation("概括信息中归属记录")
    @GetMapping("/crm/business/ascription")
    public Result<List> queryAscription(String businessTitle){
        try {
            List<FollowFromAscriptionDto> followFromAscriptionDtos = this.businessService.queryAscription(businessTitle);
            Result<List> success = Result.success(followFromAscriptionDtos);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("请求失败");
        }
    }
}