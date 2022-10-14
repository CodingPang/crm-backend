package com.greatgump.crm.controller;

import com.greatgump.crm.common.R;
import com.greatgump.crm.dto.LuoDto2;
import com.greatgump.crm.entity.Contract;
import com.greatgump.crm.service.ContractService;
import com.greatgump.crm.service.CustomerService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 合同管理 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "beta-合同管理-l")
@RestController
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private CustomerService customerService;

    @ApiOperation("展示表格")
    @GetMapping("/crm/contract/list")
    public R list(){
        return R.ok().put("合同管理列表",contractService.list());
    }


    @ApiOperation("合同管理列表增加")
    @PostMapping("/crm/contract/add")
    public R add(Contract contract){
        contractService.save(contract);
        return R.ok().put("添加成功",contract);
    }
    @ApiOperation("合同管理列表单个删除")
    @DeleteMapping("/crm/contract/delete")
    public R delete(Contract contract){
        contractService.removeById(contract);
        return R.ok().put("删除成功",contract);
    }
    @ApiOperation("合同管理系统批量删除")
    @DeleteMapping("/crm/contract/deletes")
    public R deletes(List<Contract> contracts){
        contractService.removeBatchByIds(contracts);
        return R.ok().put("删除成功",contracts);
    }

    @ApiOperation("合同管理系统修改")
    @PostMapping("/crm/contract/update")
    public R update(Contract contract){
        contractService.updateById(contract);
        return R.ok().put("修改成功",contract);
    }
    @ApiOperation("这是关联客户下拉框，会返回客户名称及id")
    @GetMapping("/crm/contract/listcustmoer")
    public Result<List<LuoDto2>> listCustomer(){
        return Result.success(customerService.queryName());
    }

    @ApiOperation("联系人的下拉框，需提供客户id")
    @GetMapping("/crm/contract/phone")
    public Result<List<String>> listPhone(){
        return Result.success(customerService.queryPhone());
    }



    public void upload(HttpServletRequest request) throws IOException{
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("file");
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
        String filename = multipartFile.getOriginalFilename();
        InputStream inputStream = multipartFile.getInputStream();
        byte[] b =new byte[1048576];
        int length = inputStream.read(b);
        path +="//"+filename;
        FileOutputStream outputStream = new FileOutputStream(path);
        outputStream.write(b,0,length);
        inputStream.close();
        outputStream.close();
    }
}
