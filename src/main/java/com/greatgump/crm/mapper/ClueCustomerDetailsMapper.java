package com.greatgump.crm.mapper;

import com.greatgump.crm.dto.chasing.ChasingRecordDto;
import com.greatgump.crm.dto.customerDetails.*;

import java.util.List;

public interface ClueCustomerDetailsMapper {

    MainInfoDto queryMainInfoById(Long id);

    List<ContactDto> queryContactDto(Long id);

    List<ChasingRecordDto> queryAllChasingRecord(Long id);

    List<ClueWorKOrderDto> querAllWorKOrderDtos(Long id);

    List<OrderDto> queryAllOrderDto(Long id);

    List<InvoiceDto> queryAllInvoiceDtos(Long id);

    List<CostDto> queryAllCostDtos(Long id);

    List<EnclosureDto> queryAllEnclosureDtos(Long id);

    List<FollowPlan> queryAllFollowPlans(Long id);

    List<BelongRecord> queryAllBelongRecords(Long id);


    List<BusinessDto> queryAllBusinessDtos(Long id);
}
