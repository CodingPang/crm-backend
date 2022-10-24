package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greatgump.crm.dto.LoanOrderDto;
import com.greatgump.crm.dto.LuoDto2;
import com.greatgump.crm.dto.UserDto0;
//import com.greatgump.crm.dto.workorder.CustomerDto;
//import com.greatgump.crm.dto.workorder.OrderDto;
import com.greatgump.crm.dto.workorder.WorkorderSearch;
import com.greatgump.crm.entity.User;
import com.greatgump.crm.entity.Workorder;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_workorder(工单)】的数据库操作Service
* @createDate 2022-10-20 14:08:35
*/
public interface WorkorderService extends IService<Workorder> {
     Page<Workorder> queryByPage(WorkorderSearch search);
     Page<Workorder> queryByPageMe(WorkorderSearch search,Integer currentUserId);
     Page<Workorder> queryByPageHandle(WorkorderSearch search,Integer currentUserId);
     Workorder queryById(Integer currentUserId);

     List<LoanOrderDto> getOrderList();
     List<LuoDto2> getCustomerList();
     List<User> getUserList();

}
