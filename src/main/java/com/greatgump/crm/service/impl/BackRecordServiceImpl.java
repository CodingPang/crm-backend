package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.dto.back.record.BackRecordAllDto;
import com.greatgump.crm.entity.BackRecord;
import com.greatgump.crm.mapper.BackRecordMapper;
import com.greatgump.crm.service.BackRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Service
public class BackRecordServiceImpl extends ServiceImpl<BackRecordMapper, BackRecord> implements
    BackRecordService {

  @Autowired
  private BackRecordMapper backRecordMapper;

  @Override
  public Page<BackRecordAllDto> queryAllBackRecord(Page<BackRecordAllDto> backRecordPage) {
    return backRecordMapper.queryAllBackRecord(backRecordPage);
  }

  @Override
  public boolean deleteByPrimaryKey(Integer id) {
    int result = backRecordMapper.deleteById(id);
    if (result != 0){
      return true;
    }
    return false;
  }
}
