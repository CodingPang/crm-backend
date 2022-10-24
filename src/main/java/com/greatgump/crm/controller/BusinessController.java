package com.greatgump.crm.controller;

import com.greatgump.crm.dto.*;
import com.greatgump.crm.dto.businessDto.*;
import com.greatgump.crm.dto.businessDto.BusinessCustomerDto;
import com.greatgump.crm.dto.businessDto.BusinessDto;
import com.greatgump.crm.dto.businessDto.BusinessDto2;
import com.greatgump.crm.dto.businessDto.BusinessSourceDto;
import com.greatgump.crm.dto.businessDto.BussinessDictionaryDto;
import com.greatgump.crm.dto.businessDto.ChasingAddDto;
import com.greatgump.crm.dto.businessDto.ChasingDto;
import com.greatgump.crm.dto.businessDto.OrderBusinessDto;
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
    @ApiOperation("主页面的商机信息")//1
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
    @ApiOperation("商机来源")//1
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
    @ApiOperation("商机阶段")//1
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
    @ApiOperation("商机关联客户")//1
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
    @ApiOperation("商机归属")//1
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
    @PostMapping("/crm/business/save")
    public Result saveBusiness(@RequestBody BusinessSourceDto businessSourceDto){
        try {
            this.businessService.saveBusiness(businessSourceDto);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("添加失败");
        }

    }


    @ApiOperation("商机主页面上表单搜索")//1
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


    @ApiOperation("主页面的根据id进行单个删除")//1
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

    @ApiOperation("主页面上根据ids批量删除")//1
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
    @ApiOperation("主页面上回显到编辑页面的内容")//1
    @GetMapping("/crm/business/pre")
    public Result queryId(Long id){
        try {
            BusinessDto2 businessDto2 = this.businessService.queryId(id);
            Result success = Result.success(businessDto2);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("回显失败");
        }
    }


    @ApiOperation("主页面上进行的编辑")
    @PutMapping("/crm/business/update")
    public Result update(@RequestBody BusinessSourceDto businessSourceDto){
        try {
            this.businessService.updateBusiness(businessSourceDto);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("编辑失败");
        }
    }


    @ApiOperation("主页面上进行跟进修改的回显")
    @GetMapping("/crm/business/chasingPre")
    public Result queryChasing(int id){
        try {
            ChasingDto chasingDto = this.businessService.queryChasing(id);
            System.out.println(chasingDto);
            Result success = Result.success(chasingDto);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("跟进回显失败");
        }
    }

    @ApiOperation("主页面上跟进的增加")
    @PostMapping("/crm/business/addchasing")
    public Result addChasing(@RequestBody ChasingAddDto chasingAddDto){
        try {
            this.businessService.saveChasing(chasingAddDto);
            return Result.success();
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("跟进失败");
        }
    }
    @ApiOperation("点击标题回转显示概括信息")
    @GetMapping("/crm/business/need")
    public Result<List> queryInformation(String businessTitle){
        try {
            List<BusinessSourceDtos> businessSourceDtos = this.businessService.queryInformation(businessTitle);

            //差东西
            Result<List> success = Result.success(businessSourceDtos);
            return success;
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("跟进失败");
        }
    }
    @ApiOperation("击标题回转显示联系人")
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

    @ApiOperation("击标题回转显示跟进记录的全部详情")
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
    @ApiOperation("击标题回转显示跟进记录单个详情")
    @GetMapping("/crm/business/plan")
    public Result queryChasingPlan(String userName,String progressiveTime){
        try {
            FollowDetailsDto followDetailsDto = this.businessService.queryChasingPlan(userName,progressiveTime);
            return Result.success(followDetailsDto);
        }catch (Exception e){
            e.printStackTrace();
            return Result.failed("跟进失败");
        }
    }
    @ApiOperation("击标题回转显示跟进计划全部显示")
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

    @ApiOperation("击标题回转显示跟进计划进行条件查询")
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

    @ApiOperation("击标题回转显示中产品报价的详情")
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
    @ApiOperation("击标题回转显示产品报价情右详上方的求总数")
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
    @ApiOperation("击标题回转显示产品报价根据id单个删除")
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

    @ApiOperation("击标题回转显示产品报价批量删除")
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
    @ApiOperation("击标题回转显示关联订单所有详情")
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


    @ApiOperation("击标题回转显示关联订单根据id单个删除")
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

    @ApiOperation("击标题回转显示相关附件")
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
    @ApiOperation("击标题回转显示相关附件根据id单个删除")
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
    @ApiOperation("击标题回转显示归属记录")
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