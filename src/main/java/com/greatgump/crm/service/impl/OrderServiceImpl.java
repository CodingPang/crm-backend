package com.greatgump.crm.service.impl;

import com.greatgump.crm.dto.LoanOrderDto;
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
    public List<LoanOrderDto> queryOrder() {

        return orderMapper.queryOrder();
    }
}
