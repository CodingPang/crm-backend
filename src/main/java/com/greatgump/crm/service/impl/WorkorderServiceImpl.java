package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.dto.LoanOrderDto;
import com.greatgump.crm.dto.LuoDto2;
import com.greatgump.crm.dto.UserDto0;
import com.greatgump.crm.dto.workorder.WorkorderSearch;
import com.greatgump.crm.entity.User;
import com.greatgump.crm.entity.Workorder;
import com.greatgump.crm.mapper.CustomerMapper;
import com.greatgump.crm.mapper.OrderMapper;
import com.greatgump.crm.mapper.UserMapper;
import com.greatgump.crm.service.WorkorderService;
import com.greatgump.crm.mapper.WorkorderMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_workorder(工单)】的数据库操作Service实现
* @createDate 2022-10-20 14:08:35
*/
@Service
public class WorkorderServiceImpl extends ServiceImpl<WorkorderMapper, Workorder>
    implements WorkorderService{

    @Autowired
    private WorkorderMapper mapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private UserMapper userMapper;

    public Page<Workorder> queryByPage(WorkorderSearch search) {
        Page<Workorder> page = new Page<>(search.getCurrent(), search.getSize());

        QueryWrapper queryWrapper = new QueryWrapper();
        //排序 倒排
//        queryWrapper.orderByAsc("menber_name");
        System.out.println(search);

        if (!StringUtils.isBlank(search.getTitle())) {
            queryWrapper.like("repair_order_title",search.getTitle());
        }
        if (search.getStatus()!=null) {
            queryWrapper.eq("workorder_status", search.getStatus());
        }
        if (search.getUrgent()!= null ) {
            queryWrapper.eq("urgent",search.getUrgent());
        }
        queryWrapper.eq("w_is_delete",0);

        mapper.queryByPage(page,queryWrapper);

        System.out.println(" 多表分页 多条件查询结果：--------->" + page.getRecords());
        return page;
    }

    @Override
    public Page<Workorder> queryByPageMe(WorkorderSearch search, Integer currentUserId) {
        Page<Workorder> page = new Page<>(search.getCurrent(), search.getSize());

        QueryWrapper queryWrapper = new QueryWrapper();
        //排序 倒排
//        queryWrapper.orderByAsc("menber_name");
        System.out.println(search);

        if (!StringUtils.isBlank(search.getTitle())) {
            queryWrapper.like("repair_order_title",search.getTitle());
        }
        if (search.getStatus()!=null) {
            queryWrapper.eq("workorder_status", search.getStatus());
        }
        if (search.getUrgent()!= null ) {
            queryWrapper.eq("urgent",search.getUrgent());
        }

        if (currentUserId!= null ) {
            queryWrapper.eq("w_initiator_id",currentUserId);
        }
        queryWrapper.eq("w_is_delete",0);
        mapper.queryByPage(page,queryWrapper);

        return page;
    }

    @Override
    public Page<Workorder> queryByPageHandle(WorkorderSearch search, Integer currentUserId) {
        Page<Workorder> page = new Page<>(search.getCurrent(), search.getSize());

        QueryWrapper queryWrapper = new QueryWrapper();
        //排序 倒排
//        queryWrapper.orderByAsc("menber_name");
        System.out.println(search);

        if (!StringUtils.isBlank(search.getTitle())) {
            queryWrapper.like("repair_order_title",search.getTitle());
        }
        if (search.getStatus()!=null) {
            queryWrapper.eq("workorder_status", search.getStatus());
        }
        if (search.getUrgent()!= null ) {
            queryWrapper.eq("urgent",search.getUrgent());
        }

        if (currentUserId != null ) {
            queryWrapper.eq("w_handler_id",currentUserId);
        }
        queryWrapper.eq("w_is_delete",0);
        mapper.queryByPage(page,queryWrapper);

        return page;
    }

    @Override
    public Workorder queryById(Integer currentUserId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("wid",currentUserId);
        queryWrapper.eq("w_is_delete",0);
        return mapper.mySelectById(queryWrapper);
    }

    @Override
    public List<LoanOrderDto> getOrderList() {

        return orderMapper.queryOrder();
    }

    @Override
    public List<LuoDto2> getCustomerList() {
        List<LuoDto2> luoDto2s = customerMapper.queryName();
        return luoDto2s;
    }

    @Override
    public List<User> getUserList() {
        return userMapper.queryAllUserName();
    }


}




