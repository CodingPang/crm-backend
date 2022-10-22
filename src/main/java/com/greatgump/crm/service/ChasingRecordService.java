package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.greatgump.crm.dto.chasing.ChasingMethodDto;
import com.greatgump.crm.dto.chasing.ChasingRecordDto;
import com.greatgump.crm.dto.clue.ClueCustomerDto;
import com.greatgump.crm.entity.ChasingRecord;

import java.util.List;

/**
 * <p>
 * 跟进记录表 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-15 04:12:19
 */
public interface ChasingRecordService extends IService<ChasingRecord> {
    List<ChasingMethodDto> queryAllChasingMethod();
    void addChasingRecord(ChasingRecord chasingRecord);
    void deleteChasingRecordById(Long id);

    List<ChasingRecordDto> queryAllChasingRecords();

    void addChasingRecordByCustomerId(ChasingRecord chasingRecord);

    List<ClueCustomerDto> queryAllCustomer();
}
