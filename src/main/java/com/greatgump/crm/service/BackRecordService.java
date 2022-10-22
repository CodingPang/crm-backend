package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greatgump.crm.dto.back.record.BackRecordAllDto;
import com.greatgump.crm.entity.BackRecord;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
public interface BackRecordService extends IService<BackRecord> {

  /**
   * 获取所有的回款记录
   * @param backRecordPage
   * @return
   */
  Page<BackRecordAllDto> queryAllBackRecord(Page<BackRecordAllDto> backRecordPage);

  /**
   * 根据id删除某条回款记录
   * @param id
   * @return
   */
  boolean deleteByPrimaryKey(Integer id);
}
