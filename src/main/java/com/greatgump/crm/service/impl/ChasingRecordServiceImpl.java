package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.dto.chasing.ChasingMethodDto;
import com.greatgump.crm.dto.chasing.ChasingRecordDto;
import com.greatgump.crm.dto.clue.ClueCustomerDto;
import com.greatgump.crm.entity.ChasingRecord;
import com.greatgump.crm.mapper.ChasingRecordMapper;
import com.greatgump.crm.service.ChasingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 跟进记录表 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-15 04:12:19
 */


@Service
public class ChasingRecordServiceImpl extends ServiceImpl<ChasingRecordMapper, ChasingRecord> implements ChasingRecordService {
    @Autowired
    private ChasingRecordMapper chasingRecordMapper;

    @Override
    public List<ChasingMethodDto> queryAllChasingMethod() {
        List<ChasingMethodDto> chasingMethodDtos = this.chasingRecordMapper.queryAllChasingMethod();
        return chasingMethodDtos;
    }

    @Override
    public void addChasingRecord(ChasingRecord chasingRecord) {
        this.chasingRecordMapper.addChasingRecord(chasingRecord);
    }

    @Override
    public void deleteChasingRecordById(Long id) {

    }

    @Override
    public List<ChasingRecordDto> queryAllChasingRecords() {
        List<ChasingRecordDto> ChasingRecordDtos = this.chasingRecordMapper.queryAllChasingRecords();
        List<ChasingRecordDto> list = this.chasingRecordMapper.queryChasingRecords();

        return ChasingRecordDtos;
    }

    @Override
    public void addChasingRecordByCustomerId(ChasingRecord chasingRecord) {
        this.chasingRecordMapper.addChasingRecordByCustomerId(chasingRecord);
    }

    @Override
    public List<ClueCustomerDto> queryAllCustomer() {
        List<ClueCustomerDto> clueCustomerDtos = this.chasingRecordMapper.queryAllCustomer();
        return clueCustomerDtos;
    }
}
