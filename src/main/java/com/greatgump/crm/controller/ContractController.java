package com.greatgump.crm.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ContactNameDto;
import com.greatgump.crm.dto.ContractDto;
import com.greatgump.crm.dto.LuoDto2;
import com.greatgump.crm.dto.UserDto0;
import com.greatgump.crm.entity.Contract;
import com.greatgump.crm.service.ContractService;
import com.greatgump.crm.service.CustomerService;
import com.greatgump.crm.service.UserService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.UUID;

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


    @ApiOperation("合同管理列表增加")
    @PostMapping("/crm/contract/add")
    public Result add(Contract contract){
        contractService.save(contract);
        return Result.success(contract);
    }
    @ApiOperation("合同管理列表单个删除")
    @DeleteMapping("/crm/contract/delete")
    public Result delete(Contract contract){
        contractService.removeById(contract);
        return Result.success(contract);
    }
    @ApiOperation("合同管理系统批量删除")
    @DeleteMapping("/crm/contract/deletes")
    public Result deletes(List<Contract> contracts){
        contractService.removeBatchByIds(contracts);
        return Result.success(contracts);
    }

    @ApiOperation("合同管理系统修改")
    @PostMapping("/crm/contract/update")
    public Result update(Contract contract){
        contractService.updateById(contract);
        return Result.success();
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


//    @ApiOperation("上传测试dataform请求传文件")
//    @RequestMapping("/crm/contract/upload")
//    public void upload(HttpServletRequest request) throws IOException{
////        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
////        MultipartFile multipartFile = multipartHttpServletRequest.getFile("file");
////        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
////        String filename = multipartFile.getOriginalFilename();
////        InputStream inputStream = multipartFile.getInputStream();
////        byte[] b =new byte[1048576];
////        int length = inputStream.read(b);
////        path +="//"+filename;
////        FileOutputStream outputStream = new FileOutputStream(path);
////        outputStream.write(b,0,length);
////        inputStream.close();
////        outputStream.close();
//    }


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

    @ApiOperation("上传测试dataform请求传文件")
    @PostMapping("/crm/contract/upload")
    public String upload02( @RequestParam(value="file",required=false)MultipartFile file, HttpServletRequest request) throws IOException {
        //1.得到本地服务目录的地址
        String path = request.getSession().getServletContext().getRealPath("upload");
        System.out.println(path);
        //2.判断该目录是否存在
//        File file1 = new File(path);
//        if (!file1.exists()) {
//            file1.mkdirs();
//        }
        //3.把myfile保存到本地文件夹中
        //随机一个文件名字
        String filename=file.getOriginalFilename();
//        File target=new File(path+"/"+filename);
//        //把file转到目标目录下
//        file.transferTo(target);
//        System.out.println("filename========>"+filename);


        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-chengdu.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "LTAI5tC9j1JopSJiQnnpkgns";
        String accessKeySecret = "olIwhVDsSpLByE8A7JkoaAdzN419Ne";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "pic28";
        //你上传到oss后的名字 会根据日期帮你创建文件夹。
        String objectName =filename;
        // 创建OSSClient实例。
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
        return url;




//
//        // Endpoint填写为https://oss-cn-chengdu.aliyuncs.com。
//        String endpoint = "https://oss-cn-chengdu.aliyuncs.com";
//        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
//        String accessKeyId = "LTAI5tC9j1JopSJiQnnpkgns";
//        String accessKeySecret = "olIwhVDsSpLByE8A7JkoaAdzN419Ne";
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//        String objectname = "file/" + System.currentTimeMillis()+"/demo/";
//        // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
//        InputStream inputStream = new FileInputStream("D:\\apache-tomcat-9.0.12\\webapps\\crm\\upload\\"+filename);
//        //调用oss实现上传第一个参数bucket名称  第二个参数文件名称  第三个参数输入流
//        String url = objectname+filename;
//        ossClient.putObject("pic28", url, inputStream);
//        // 关闭OSSClient。
//        ossClient.shutdown();
//        //返回组成的文件url
//        String photoUrl = "https://" + "mgmf." + "oss-cn-chengdu.aliyuncs.com"+ "/" + url;
//        System.out.println(photoUrl);
//
//        return "";
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
}
