package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.OrderContextDto;
import com.greatgump.crm.entity.Ordercontext;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface OrdercontextService extends IService<Ordercontext> {

    Page<OrderContextDto> listIneed(Page<OrderContextDto> offerListDtoPage);
}
