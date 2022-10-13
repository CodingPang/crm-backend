package com.greatgump.crm.controller;

import com.greatgump.crm.common.R;
import com.greatgump.crm.entity.Offer;
import com.greatgump.crm.entity.Property;
import com.greatgump.crm.service.PropertyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 * 产品属性 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@RestController
//@RequestMapping("/crm/property")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @ApiOperation("产品属性主界面列表")
    @GetMapping("/crm/property/list")
    public R list(){
        System.out.println(propertyService.list());
        return R.ok().put("propertylist",propertyService.list());
    }

    @ApiOperation("产品属性页面增加")
    @PostMapping("/crm/property/add")
    public R add(Property property){
        propertyService.save(property);
        return R.ok().put("propertyadd",property);
    }

    @ApiOperation("产品属性页面修改")
    @PutMapping("/crm/property/update")
    private R update(Property property){

        propertyService.updateById(property);
        return R.ok().put("propertyupdate",property);
    }

    @ApiOperation("产品属性页面删除")
    @DeleteMapping("/crm/property/delete")
    public R delete(Long id){
        propertyService.removeById(id);
        return R.ok().put("propertydelete",id);
    }


}
