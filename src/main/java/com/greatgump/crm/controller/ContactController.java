package com.greatgump.crm.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ContactDto;
import com.greatgump.crm.entity.Contact;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.service.ContactService;
import com.greatgump.crm.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 企业联系人表 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Api(tags = "联系人模块说明")
@RestController
@RequestMapping("/crm/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;
    @ApiOperation("获取所有联系人")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "current",value ="当前页数",required = true),@ApiImplicitParam(name = "size",value = "每页的条数",required = true)})
    @GetMapping("/contacts/{current}/{size}")
    public Result<List<ContactDto>> getAllContact(@PathVariable("current") int current, @PathVariable("size") int size){
        Page<ContactDto> contactPage = new Page(current,size);
        Page<ContactDto> pageInfo = contactService.queryAllContact(contactPage);

        return Result.success(pageInfo.getRecords(),pageInfo.getTotal());
    }

    @ApiOperation("关键字查询联系人")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "keywords",value ="查询的关键字",required = true),
                                @ApiImplicitParam(name = "current",value ="当前页数",required = true),
                                @ApiImplicitParam(name = "size",value = "每页的条数",required = true)
    })
    @GetMapping("/contacts/{keywords}/{current}/{size}")
    public Result<List<ContactDto>> queryContactDynamic(@PathVariable("keywords") String keywords,@PathVariable("current") int current, @PathVariable("size") int size){
        Page<ContactDto> contactPage = new Page(current,size);
        Page<ContactDto> pageInfo = contactService.queryContactDynamic(keywords,contactPage);

        return Result.success(pageInfo.getRecords(),pageInfo.getTotal());
    }

    @ApiOperation("添加联系人")
    @PostMapping("/contacts")
    public Result saveContact(@RequestBody Contact contact){

        int s = contactService.saveContact(contact);
        return s>0?Result.success():Result.failed();
    }

    @ApiOperation("编辑联系人--点击保存")
    @PutMapping("/contacts")
    public Result editContact(@RequestBody Contact contact){

        int u = contactService.updateContact(contact);
        return Result.judge(u>0?true:false);
    }

    @ApiOperation("编辑联系人--点击编辑")
    @PutMapping("/contacts/{cuid}")
    public Result<ContactDto> preEditContact(@PathVariable("cuid")Integer cuid){
        ContactDto contactDto = contactService.queryContactById(cuid);
        return Result.success(contactDto);
    }

    @ApiOperation("单个删除联系人")
    @DeleteMapping("/contacts/{id}")
    public Result deleteById(@PathVariable Integer id){
        boolean b = contactService.removeById(id);
        return Result.judge(b);
    }

    @ApiOperation("批量删除联系人")
    @DeleteMapping("/contacts")
    public Result batchDelete(@RequestBody List<Contact> contacts){
        boolean b = false;
        for (Contact contact : contacts) {
            b = contactService.removeById(contact.getId());
        }

        return Result.judge(b);
    }
}
