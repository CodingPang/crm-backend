package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.entity.BackRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Mapper
public interface BackRecordMapper extends BaseMapper<BackRecord> {

  /**
   * 查询所有的回款记录
   * @param backRecordPage
   * @return
   */
  Page<BackRecord> queryAllBackRecord(Page<BackRecord> backRecordPage);
}
