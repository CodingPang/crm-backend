package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.greatgump.crm.dto.FollowDetailsDto;
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
    /*
     *售前跟进管理全部
     */
    List<FollowDetailsDto> queryChasingRecordAll();
}
