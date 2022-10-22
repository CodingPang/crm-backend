package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.dto.FollowDetailsDto;
import com.greatgump.crm.entity.ChasingRecord;
import com.greatgump.crm.mapper.ChasingRecordMapper;
import com.greatgump.crm.service.ChasingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<FollowDetailsDto> queryChasingRecordAll() {
        List<FollowDetailsDto> followDetailsDtos = this.chasingRecordMapper.queryChasingRecordAll();
        return followDetailsDtos;
    }
}
