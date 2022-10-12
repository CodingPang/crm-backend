package com.greatgump.crm.service.impl;

import com.greatgump.crm.entity.Order;
import com.greatgump.crm.mapper.OrderMapper;
import com.greatgump.crm.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
