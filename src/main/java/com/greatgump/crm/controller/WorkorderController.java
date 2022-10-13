package com.greatgump.crm.controller;

import com.greatgump.crm.entity.Workorder;
import com.greatgump.crm.service.WorkorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 工单 前端控制器
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@RestController
@RequestMapping("/crm/workorder")
public class WorkorderController {
    @Autowired
    private WorkorderService workorderService;
    //新增工单
    @PostMapping("/addOrder ")
    @ResponseBody
    public int addOrder(@RequestBody Workorder workorder) {
        int i = workorderService.add(workorder);
        String customerName = workorder.getCustomerName(); // 测试
        return  i;

    }

    }


