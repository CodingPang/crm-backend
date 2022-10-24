package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.LoanOrderDto;
import com.greatgump.crm.dto.OrderSearchDto;
import com.greatgump.crm.entity.Order;
import com.greatgump.crm.mapper.OrderMapper;
import com.greatgump.crm.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Page<Order> listIneed(Page<Order> offerListDtoPage) {
        return orderMapper.listIneed(offerListDtoPage);
    }

    @Override
    public List<Order> searchIneed(OrderSearchDto orderSearchDto) {
        return orderMapper.searchIneed(orderSearchDto);
    }

    @Override
    public List<LoanOrderDto> queryOrder() {

        return orderMapper.queryOrder();
    }
}
