package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.OrderContextDto;
import com.greatgump.crm.entity.Ordercontext;
import com.greatgump.crm.mapper.OrdercontextMapper;
import com.greatgump.crm.service.OrdercontextService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class OrdercontextServiceImpl extends ServiceImpl<OrdercontextMapper, Ordercontext> implements OrdercontextService {
    @Autowired
    private OrdercontextMapper ordercontextMapper;
    @Override
    public Page<OrderContextDto> listIneed(Page<OrderContextDto> offerListDtoPage) {
        return ordercontextMapper.listIneed(offerListDtoPage);
    }
}
