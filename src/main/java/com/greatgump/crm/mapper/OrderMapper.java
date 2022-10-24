package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.LoanOrderDto;
import com.greatgump.crm.dto.OrderSearchDto;
import com.greatgump.crm.dto.finance.cost.OrderListDto;
import com.greatgump.crm.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

  /**
   * 查询费用记录需要用到的所有订单
   * @return
   */
  List<OrderListDto> selectOrderListDto();

    Page<Order> listIneed(Page<Order> offerListDtoPage);


    List<Order> searchIneed(OrderSearchDto orderSearchDto);

  List<LoanOrderDto> queryOrder();


    Long searchCount(OrderSearchDto orderSearchDto);
}
