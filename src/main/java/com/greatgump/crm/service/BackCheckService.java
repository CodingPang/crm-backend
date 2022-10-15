package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greatgump.crm.dto.BackCheckDto;
import com.greatgump.crm.entity.BackCheck;

/**
 * <p>
 * 回款审批 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
public interface BackCheckService extends IService<BackCheck> {

  /**
   * 查询所有的回款审批对象
   * @param backCheckDtoPage
   * @return
   */
  Page<BackCheckDto> queryAllBackCheck(Page<BackCheckDto> backCheckDtoPage);
}
