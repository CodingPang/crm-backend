package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.dto.chasing.ChasingRecordDto;
import com.greatgump.crm.dto.clue.*;
import com.greatgump.crm.dto.customerDetails.*;
import com.greatgump.crm.dto.customerDetails.BusinessDto;
import com.greatgump.crm.dto.customerDetails.ContactDto;
import com.greatgump.crm.dto.customerDetails.OrderDto;
import com.greatgump.crm.entity.Clue;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 线索管理 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface ClueService extends IService<Clue> {
        List<ClueDto> quryallClue();

    boolean saveClue(ClueReceiveDto clueReceiveDto);

   boolean update( ClueReceiveDto clueReceiveDto);
       boolean lookup( ClueReceiveDto clueReceiveDto);

  /**
   * 1、根据id查询这条数据在线索表的记录
   * @param id
   * @return
   */
  CluePreEditDto queryOneClue(Integer id);

      List<ClueOrigin> queryAllClueOrigin();
      List<ClueStatus> queryAllClueStatus();
      List<ClueUser> queryAllClueUser();

    void addClueReceive(ClueReceiveDto clueReceiveDto);

    ClueReceiveDto editPreClueReceive(Long id);

    void updateClueReceiveByClueReceiveDto(ClueReceiveDto clueReceiveDto);
    void deleteClueById(Long id);

//    ClueDto selectClueReceiveDtoByCondition(String username, Long OriginId, Long statusId, Date startDate,Date endDate);

    List<ClueDto> selectClueDtoByCondition(String username, Long OriginId, Long statusId, Date startDate,Date endDate);

    List<ClueContact> queryAllClueContact();

    List<ClueDept> queryAllClueDept();

    MainInfoDto queryMainInfoById(Long id);

    List<ContactDto> queryContactDto(Long id);

    List<ChasingRecordDto> queryAllChasingRecord(Long id);

    List<ClueWorKOrderDto> querAllWorKOrderDtos(Long id);

    List<OrderDto> queryAllOrderDto(Long id);

    List<InvoiceDto> queryAllInvoiceDtos(Long id);

    List<CostDto> queryAllCostDtos(Long id);

    List<EnclosureDto> queryAllEnclosureDtos(Long id);


    List<ClueCustomerDto> queryAllClueCustomerDto();

    List<FollowPlan> queryAllFollowPlans(Long id);

    List<BelongRecord> queryAllBelongRecords(Long id);


    Page<ClueDto> queryListClue(Page<ClueDto> offerListDtoPage);

    List<BusinessDto> queryAllBusinessDtos(Long id);
}
