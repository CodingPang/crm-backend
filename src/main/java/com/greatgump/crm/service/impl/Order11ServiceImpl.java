package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.entity.Management;
import com.greatgump.crm.entity.Order11;
import com.greatgump.crm.mapper.ManagementMapper;
import com.greatgump.crm.mapper.Order11Mapper;
import com.greatgump.crm.service.ManagementService;
import com.greatgump.crm.service.Order11Service;
import org.springframework.stereotype.Service;

@Service
public class Order11ServiceImpl extends ServiceImpl<Order11Mapper, Order11> implements Order11Service{
}
