package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.dto.back.BackCheckDto;
import com.greatgump.crm.entity.BackCheck;
import com.greatgump.crm.entity.BackRecord;
import com.greatgump.crm.mapper.BackCheckMapper;
import com.greatgump.crm.mapper.BackRecordMapper;
import com.greatgump.crm.service.BackCheckService;
import com.greatgump.crm.utils.LocalDateTimeUtils;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 回款审批 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Service
public class BackCheckServiceImpl extends ServiceImpl<BackRecordMapper, BackRecord> implements BackCheckService {

  @Autowired
  private BackRecordMapper backRecordMapper;

  @Override
  public Page<BackRecord> queryAllBackCheck(Page<BackRecord> backRecordPage) {
    return backRecordMapper.queryAllBackCheck(backRecordPage);
  }

  @Override
  public List<BackRecord> queryAllByCondition(Integer current, Integer size,
      BackRecord backRecord) {

    return backRecordMapper.selectAllByCondition(current,size,backRecord);
  }

  @Override
  public List<BackRecord> queryAllByCondition(Integer current, Integer size, Integer checkStatus,
      String submitStartTime, String submitEndTime) {
    return backRecordMapper.selectAllWithCondition(current,size,checkStatus,submitStartTime,submitEndTime);
  }

  @Override
  public BackRecord preUpdate(Integer id) {
    return backRecordMapper.selectByPrimaryId(id);
  }

  @Override
  public boolean updateOne(Integer id, Integer checkStatus, String remark) {
    // 检查时间
    Date date = new Date(System.currentTimeMillis());
    LocalDateTime localDateTime = LocalDateTimeUtils.dateToLocalDateTime(date);
    String checkTime = LocalDateTimeUtils.LocalDateTimeByFormat(localDateTime,
        LocalDateTimeUtils.YYYY_MM_DD_HH_MM_SS_PATTERN);

    boolean result = backRecordMapper.updateOne(id, checkStatus, remark, checkTime);
    if (result){ // 如果更改成功，则返回插入成功后的当条数据
//      List<BackRecord> backRecord = backRecordMapper.selectAllbackRecord();
      return true;
    }
    return false;
    /*if (result != 0){
      return true;
    }
    return false;*/
  }
}
