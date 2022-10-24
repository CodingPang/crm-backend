package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ClueDto;
import com.greatgump.crm.dto.ClueReceiveDto;
import com.greatgump.crm.dto.chasing.ChasingRecordDto;
import com.greatgump.crm.dto.clue.*;
import com.greatgump.crm.dto.customerDetails.*;
import com.greatgump.crm.entity.Clue;
import com.greatgump.crm.mapper.ClueCustomerDetailsMapper;
import com.greatgump.crm.mapper.ClueMapper;
import com.greatgump.crm.mapper.ClueReceiveDtoMapper;
import com.greatgump.crm.mapper.FollowFormMapper;
import com.greatgump.crm.service.ClueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 线索管理 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class ClueServiceImpl extends ServiceImpl<ClueMapper, Clue> implements ClueService {

      @Autowired
      private FollowFormMapper followFormMapper;

      @Autowired
      private ClueMapper clueMapper;

      @Autowired
      private ClueReceiveDtoMapper clueReceiveDtoMapper;

      @Autowired
      private ClueCustomerDetailsMapper clueCustomerDetailsMapper;


    @Override
    public List<ClueDto> quryallClue() {

        List<ClueDto> clueDtoPage = this.clueMapper.queryAllClue();

        return clueDtoPage;
    }

    @Override
    public Page<ClueDto> queryListClue(Page<ClueDto> offerListDtoPage) {
        return this.clueMapper.queryListClue(offerListDtoPage);
    }

    @Override
    public boolean saveClue(ClueReceiveDto clueReceiveDto) {
        return followFormMapper.insertClue(clueReceiveDto);
    }

    @Override
    public boolean update(ClueReceiveDto clueReceiveDto) {
        return followFormMapper.updateClue(clueReceiveDto);
    }

    @Override
    public boolean lookup(ClueReceiveDto clueReceiveDto) {
        return false;
    }

    @Override
    public CluePreEditDto queryOneClue(Integer id) {
        return followFormMapper.selectOneClue(id);
    }

    @Override
    public List<ClueOrigin> queryAllClueOrigin() {
        List<ClueOrigin> clueOrigins = this.clueMapper.queryAllClueOrigin();
        return clueOrigins;
    }

    @Override
    public List<ClueStatus> queryAllClueStatus() {

        List<ClueStatus> clueStatuses = this.clueMapper.queryAllClueStatus();
        return clueStatuses;
    }

    @Override
    public List<ClueUser> queryAllClueUser() {

        List<ClueUser> clueUsers = this.clueMapper.queryAllClueUser();
        return clueUsers;
    }

    @Override
    public void addClueReceive(ClueReceiveDto clueReceiveDto) {

        this.clueReceiveDtoMapper.addContact(clueReceiveDto);

        Long d1 = clueReceiveDto.getContactId();

        System.out.println(d1);

        clueReceiveDto.setContactId(d1);

        this.clueReceiveDtoMapper.addFollowForm(clueReceiveDto);

        Long d2 = clueReceiveDto.getFollowFormId();

        System.out.println(d2);

        clueReceiveDto.setFollowFormId(d2);

        this.clueReceiveDtoMapper.addChasingRecord(clueReceiveDto);

    }

    @Override
    public ClueReceiveDto editPreClueReceive(Long id) {
        ClueReceiveDto clueReceiveDto = this.clueReceiveDtoMapper.editPreClueReceive(id);
        return clueReceiveDto;
    }

    @Override
    public void updateClueReceiveByClueReceiveDto(ClueReceiveDto clueReceiveDto) {
        this.clueReceiveDtoMapper.updateClueReceiveByClueReceiveDto(clueReceiveDto);
    }

    @Override
    public void deleteClueById(Long id) {

        this.clueReceiveDtoMapper.deleteClueById(id);
    }


//    @Override
//    public ClueReceiveDto selectClueReceiveDtoByCondition(String username, Long originId, Long statusId, Date startDate, Date endDate) {
//        ClueReceiveDto clueReceiveDto = this.clueReceiveDtoMapper.selectClueReceiveDtoByCondition(username,originId,statusId,startDate,endDate);
//        return clueReceiveDto;
//    }


    @Override
    public List<ClueDto> selectClueDtoByCondition(String username, Long originId, Long statusId, Date startDate, Date endDate) {

        List<ClueDto>  clueDtos= this.clueMapper.selectClueDtoByCondition(username,originId,statusId,startDate,endDate);
        return clueDtos;
    }

    @Override
    public List<ClueContact> queryAllClueContact() {

        List<ClueContact> clueContacts = this.clueMapper.queryAllClueContact();

        return clueContacts;
    }

    @Override
    public List<ClueDept> queryAllClueDept() {
        List<ClueDept> clueDepts = this.clueMapper.queryAllClueDept();
        return clueDepts;
    }

    @Override
    public MainInfoDto queryMainInfoById(Long id) {
        MainInfoDto mainInfoDto = this.clueCustomerDetailsMapper.queryMainInfoById(id);
        return mainInfoDto;
    }

    @Override
    public List<ContactDto> queryContactDto(Long id) {
        List<ContactDto> contactDtos = this.clueCustomerDetailsMapper.queryContactDto(id);
        return contactDtos;
    }

    @Override
    public List<ChasingRecordDto> queryAllChasingRecord(Long id) {
        List<ChasingRecordDto> chasingRecordDtos = this.clueCustomerDetailsMapper.queryAllChasingRecord(id);
        return chasingRecordDtos;
    }

    @Override
    public List<ClueWorKOrderDto> querAllWorKOrderDtos(Long id) {
        List<ClueWorKOrderDto> worKOrderDtos = this.clueCustomerDetailsMapper.querAllWorKOrderDtos(id);
        return worKOrderDtos;
    }

    @Override
    public List<OrderDto> queryAllOrderDto(Long id) {
        List<OrderDto> orderDtos = this.clueCustomerDetailsMapper.queryAllOrderDto(id);
        return orderDtos;
    }

    @Override
    public List<InvoiceDto> queryAllInvoiceDtos(Long id) {
        List<InvoiceDto> invoiceDtos = this.clueCustomerDetailsMapper.queryAllInvoiceDtos(id);
        return invoiceDtos;
    }

    @Override
    public List<CostDto> queryAllCostDtos(Long id) {
        List<CostDto> costDtos = this.clueCustomerDetailsMapper.queryAllCostDtos(id);
        return costDtos;
    }

    @Override
    public List<EnclosureDto> queryAllEnclosureDtos(Long id) {
        List<EnclosureDto> enclosureDtos = this.clueCustomerDetailsMapper.queryAllEnclosureDtos(id);
        return enclosureDtos;
    }

    @Override
    public List<ClueCustomerDto> queryAllClueCustomerDto() {
        List<ClueCustomerDto> clueCustomerDtos = this.clueMapper.queryAllClueCustomerDto();
        return clueCustomerDtos;
    }


    @Override
    public List<FollowPlan> queryAllFollowPlans(Long id) {
        List<FollowPlan> followPlans = this.clueCustomerDetailsMapper.queryAllFollowPlans(id);
        return followPlans;
    }

    @Override
    public List<BelongRecord> queryAllBelongRecords(Long id) {
        List<BelongRecord> belongRecords = this.clueCustomerDetailsMapper.queryAllBelongRecords(id);

        return belongRecords;
    }

    @Override
    public List<BusinessDto> queryAllBusinessDtos(Long id) {
        List<BusinessDto> businessDtos = this.clueCustomerDetailsMapper.queryAllBusinessDtos(id);
        return businessDtos;
    }
}


