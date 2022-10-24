package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.OrderSearchDto;
import com.greatgump.crm.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface OrderService extends IService<Order> {

    Page<Order> listIneed(Page<Order> offerListDtoPage);

    Page<Order> searchIneed(OrderSearchDto orderSearchDto);
}
