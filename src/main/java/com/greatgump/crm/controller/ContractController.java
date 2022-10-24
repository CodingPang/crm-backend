package com.greatgump.crm.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.Contract;
import com.greatgump.crm.entity.Offer;
import com.greatgump.crm.service.ContractService;
import com.greatgump.crm.service.CustomerService;
import com.greatgump.crm.service.UserService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * <p>
 * 合同管理 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "AAA合同管理")
@RestController
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;

    @ApiOperation("合同搜索")
    @PostMapping("/crm/contract/search")
    public Result<List<OfferListDto>> search(@RequestBody OfferSearchDto offerSearchDto){
        System.out.println("offersearch===========>"+offerSearchDto);
        List<OfferListDto> offerListDtoPage= contractService.searchList(offerSearchDto);
        Long count = Long.valueOf(contractService.countList(offerSearchDto));
        return Result.success(offerListDtoPage,count);
    }

    @ApiOperation("编辑按钮返回下拉框信息")
    @PostMapping("/crm/contract/preupdate")
    public Result<Contract> preUpdate(Long id){
        return Result.success(contractService.getById(id));
    }
//    @ApiOperation("编辑按钮返回下拉框信息")
//    @PostMapping("/crm/contract/preupdate")
//    public Result<ContractUpdateDto> preUpdate(Long id){
//       return Result.success(contractService.getByIdDto(id));
//    }
    public Result list(){
//        return R.ok().put("合同管理列表",contractService.list());
        return Result.success(contractService.list(),1L);
    }
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @ApiOperation("展示表格")
    @GetMapping("/crm/contract/list/{current}/{size}")
    public Result<List<ContractDto>> list1(@PathVariable("current")int current,@PathVariable("size")int size){
       Page<ContractDto> offerListDtoPage = new Page<>(current,size);
        Page<ContractDto> offerListDtoPage1 = contractService.listIneed(offerListDtoPage);
        return Result.success(offerListDtoPage1.getRecords(),offerListDtoPage1.getTotal());
    }


//    @ApiOperation("合同管理列表增加")
//    @PostMapping("/crm/contract/add")
//    public Result add(@RequestBody Contract contract){
//        String str = RandomStringUtils.randomAlphabetic(5);
//        contract.setContractNum("CN-SC-CD-"+str);
//        contractService.save(contract);
//        return Result.success(contract);
//    }
    @ApiOperation("合同管理列表单个删除")
    @DeleteMapping("/crm/contract/delete")
    public Result delete(Long id){
        Contract contract = contractService.getById(id);
        contract.setIsDelete(1);
        boolean flag = contractService.updateById(contract);
        return Result.judge(flag);
    }
    @ApiOperation("合同管理系统批量删除")
    @DeleteMapping("/crm/contract/deletes")
    public Result deletes(List<Contract> contracts){
        contractService.removeBatchByIds(contracts);
        return Result.success(contracts);
    }

    @ApiOperation("合同管理系统修改")
    @PostMapping("/crm/contract/update")
    public Result update(@RequestParam(value="file",required=false)MultipartFile file, Contract contract)throws IOException{
        String filename=file.getOriginalFilename();

        String endpoint = "oss-cn-chengdu.aliyuncs.com";
        String accessKeyId = "LTAI5tC9j1JopSJiQnnpkgns";
        String accessKeySecret = "olIwhVDsSpLByE8A7JkoaAdzN419Ne";
        String bucketName = "pic28";
        String objectName =filename;
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            InputStream inputStream = file.getInputStream();
            // 创建PutObject请求。
            ossClient.putObject(bucketName, objectName, inputStream);
        } catch (Exception oe) {

        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        String url = "https://" + bucketName + "." + endpoint + "/" + objectName;
        contract.setContracUrl(url);
        boolean flag = contractService.updateById(contract);
        return Result.judge(flag);

    }
    @ApiOperation("这是关联客户下拉框，会返回客户名称及id")
    @GetMapping("/crm/contract/listcustmoer")
    public Result<List<LuoDto2>> listCustomer(){
        return Result.success(customerService.queryName());
    }

    @ApiOperation("联系人的下拉框，需提供客户id")
    @GetMapping("/crm/contract/phone")
    public Result<List<ContactNameDto>> listPhone(Long id){
        return Result.success(customerService.queryPhone(id));
    }


    public String upload01( @RequestParam(value="file",required=false)MultipartFile file, HttpServletRequest request) throws IOException {
        //1.得到本地服务目录的地址
        String path = request.getSession().getServletContext().getRealPath("upload");
        System.out.println(path);
        //2.判断该目录是否存在
        File file1 = new File(path);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        //3.把myfile保存到本地文件夹中
        //随机一个文件名字
        String filename=file.getOriginalFilename();
        File target=new File(path+"/"+filename);
        //把file转到目标目录下
        file.transferTo(target);
        return "";
    }

    @ApiOperation("合同添加")
    @PostMapping("/crm/contract/upload")
    public Result upload02( @RequestParam(value="file",required=false)MultipartFile file, Contract contract) throws IOException {

        String filename=file.getOriginalFilename();

        String endpoint = "oss-cn-chengdu.aliyuncs.com";
        String accessKeyId = "LTAI5tC9j1JopSJiQnnpkgns";
        String accessKeySecret = "olIwhVDsSpLByE8A7JkoaAdzN419Ne";
        String bucketName = "pic28";
        String objectName =filename;
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            InputStream inputStream = file.getInputStream();
            // 创建PutObject请求。
            ossClient.putObject(bucketName, objectName, inputStream);
        } catch (Exception oe) {

        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

        String str = RandomStringUtils.randomAlphabetic(5);
        contract.setContractNum("CN-SC-CD"+str);
        String url = "https://" + bucketName + "." + endpoint + "/" + objectName;
        contract.setContracUrl(url);
        boolean flag = contractService.save(contract);
        return Result.judge(flag);
    }

    @ApiOperation("关联客户下拉框")
    @GetMapping("/crm/contract/getbox1")
    public Result<List<LuoDto2>> getBox1(){
        return Result.success(contractService.list01());
    }

    @ApiOperation("这是业务员下拉框，会返回业务员名称及id")
    @GetMapping("/crm/contract/getbox2")
    public  Result<List<UserDto0>> getBox2(){
        return Result.success(userService.getName());
    }

    @ApiOperation("联系人的下拉框，需提供客户id")
    @GetMapping("/crm/contract/getbox3")
    public Result<List<ContactNameDto>> getbox3(Long id){
        return Result.success(customerService.queryPhone(id));
    }


    @ApiOperation("这是我方签订人下拉框，会返回业务员名称及id")
    @GetMapping("/crm/contract/getbox4")
    public  Result<List<UserDto0>> getBox4(){
        return Result.success(userService.getName());
    }
//    @ApiOperation("合同页面删除")
//    @DeleteMapping("/crm/contract/delete1")
//    public Result delete(Long id){
//        boolean flag = contractService.removeById(id);
//        return Result.judge(flag);
//    }
@ApiOperation("点击标题后的信息")
@PostMapping("/crm/contract/title")
public Result<ContractDto> title(Long id){
    return Result.success(contractService.getForTitle(id));
}

}
