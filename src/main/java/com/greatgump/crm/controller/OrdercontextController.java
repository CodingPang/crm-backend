package com.greatgump.crm.controller;

import cn.hutool.json.JSONArray;
import com.alibaba.fastjson.JSON;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.*;
import com.greatgump.crm.service.*;
import com.greatgump.crm.utils.Result;
import com.hazelcast.internal.json.Json;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "AAA订单管理-l")
@RestController
public class OrdercontextController {
    @Autowired
    private OrdercontextService ordercontextService;
    @Autowired
    private OfferDetailsService offerDetailsService;
    @Autowired
    private Order11Service order11Service;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BusinessService businessService;
    @Autowired
    private UploadAttachmentService uploadAttachmentService;

    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @ApiOperation("展示订单")
    @GetMapping("/crm/ordercontext/list/{current}/{size}")
    public Result<List<Order>> list(@PathVariable("current")int current, @PathVariable("size")int size){
        Page<Order> offerListDtoPage = new Page<>(current,size);
        Page<Order> offerListDtoPage1 = orderService.listIneed(offerListDtoPage);
        return Result.success(offerListDtoPage1.getRecords(),offerListDtoPage1.getTotal());
    }

    @ApiOperation("这是关联客户下拉框，会返回客户名称及id")
    @GetMapping("/crm/ordercontext/listcustmoer")
    public Result<List<LuoDto2>> listCustomer(){
        return Result.success(customerService.queryName());
    }

    @ApiOperation("这是订单归属下拉框")
    @GetMapping("/crm/ordercontext/getbox2")
    public  Result<List<UserDto0>> getBox2(){
        return Result.success(userService.getName());
    }

    @ApiOperation("这是关联商机下拉框")
    @GetMapping("/crm/ordercontext/getbox3")
    public Result<List<BusinessTitleDto>> getTitle(){
        return Result.success(businessService.listTitle());
    }

    @ApiOperation("订单修改")
    @PostMapping("/crm/ordercontext/update")
    public Result upload03(@RequestParam(value="file",required=false) MultipartFile file,Order11 order11,String offerDetails1,String offerDetails2) throws IOException {
        List<OfferDetails> offerDetails = JSON.parseArray(offerDetails1,OfferDetails.class);
        List<OfferDetails> offerDetailsu =JSON.parseArray(offerDetails2,OfferDetails.class);
        String filename=file.getOriginalFilename();
        String endpoint = "oss-cn-chengdu.aliyuncs.com";
        String accessKeyId = "LTAI5tC9j1JopSJiQnnpkgns";
        String accessKeySecret = "olIwhVDsSpLByE8A7JkoaAdzN419Ne";
        String bucketName = "pic28";
        String objectName =filename;
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(bucketName, objectName, inputStream);
        } catch (Exception oe) {
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        String url = "https://" + bucketName + "." + endpoint + "/" + objectName;
        UploadAttachment upload = new UploadAttachment();
        upload.setUploadLocation(url);
        uploadAttachmentService.save(upload);
        order11.setUploadAttachment(upload.getId());
        String str = RandomStringUtils.randomAlphabetic(6);
        order11.setOrderNo("CN-SC-CD"+str);
        boolean flag = order11Service.save(order11);
        for (OfferDetails offerDetail:offerDetails ) {
            offerDetail.setRemake(order11.getId());
        }
        for (OfferDetails offerDetail:offerDetailsu ) {
            offerDetail.setRemake(null);
        }
        offerDetailsService.updateBatchById(offerDetails);
        offerDetailsService.updateBatchById(offerDetailsu);
        return Result.judge(flag);
    }
    @ApiOperation("订单添加")
    @PostMapping("/crm/ordercontext/upload")
    public Result upload02(@RequestParam(value="file",required=false) MultipartFile file,Order11 order11,String offerDetails1) throws IOException {
        List<OfferDetails> offerDetails = JSON.parseArray(offerDetails1,OfferDetails.class);
        String filename=file.getOriginalFilename();
        String endpoint = "oss-cn-chengdu.aliyuncs.com";
        String accessKeyId = "LTAI5tC9j1JopSJiQnnpkgns";
        String accessKeySecret = "olIwhVDsSpLByE8A7JkoaAdzN419Ne";
        String bucketName = "pic28";
        String objectName =filename;
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(bucketName, objectName, inputStream);
        } catch (Exception oe) {
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        String url = "https://" + bucketName + "." + endpoint + "/" + objectName;
        UploadAttachment upload = new UploadAttachment();
        upload.setUploadLocation(url);
        uploadAttachmentService.save(upload);
        order11.setUploadAttachment(upload.getId());
        String str = RandomStringUtils.randomAlphabetic(6);
        order11.setOrderNo("CN-SC-CD"+str);
        boolean flag = order11Service.save(order11);
        for (OfferDetails offerDetail:offerDetails ) {
            offerDetail.setRemake(order11.getId());
        }
        offerDetailsService.updateBatchById(offerDetails);
        return Result.judge(flag);
    }
    @ApiOperation("关联商品按钮")
    @PostMapping("/crm/ordercontext/getpro/{id}/{current}/{size}")
    private Result listPro(@PathVariable("id") int id, @PathVariable("current") int current,@PathVariable("size") int size){

       return Result.success(offerDetailsService.listBycompany(id,current,size),offerDetailsService.listBycompanyCount(id));
    }

    @ApiOperation("修改关联商品按钮")
    @PostMapping("/crm/ordercontext/getproupdate")
    private Result listPro1(@RequestBody OfferDetailsUpdateListDto dto){
        return Result.success(offerDetailsService.listBycompanyUpdate(dto),offerDetailsService.listBycompanyCountUpdate(dto));
    }

    @ApiOperation("预编辑")
    @GetMapping("/crm/ordercontext/preupdate/{id}")
    public Result<Order11> preUpdate(@PathVariable("id") Long id){
       return Result.success(order11Service.getById(id));
    }

    @ApiOperation("这是我方签订人下拉框，会返回业务员名称及id")
    @GetMapping("/crm/ordercontext/getbox4")
    public  Result<List<UserDto0>> getBox4(){
        return Result.success(userService.getName());
    }

    @ApiOperation("订单搜索")
    @PostMapping("/crm/ordercontext/list")
    public Result<List<Order>> search(@RequestBody OrderSearchDto orderSearchDto){
        List<Order> offerListDtoPage1 = orderService.searchIneed(orderSearchDto);
        return Result.success(offerListDtoPage1);
    }

    @ApiOperation("订单删除")
    @DeleteMapping("/crm/ordercontext/list")
    public Result delete(Long id){
        return Result.success(order11Service.removeById(id));
    }
}
