package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.greatgump.crm.dto.BackCheckDto;
import com.greatgump.crm.dto.BackCheckDto;
import com.greatgump.crm.entity.BackCheck;
import com.greatgump.crm.mapper.BackCheckMapper;
import com.greatgump.crm.service.BackCheckService;
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
public class BackCheckServiceImpl extends ServiceImpl<BackCheckMapper, BackCheck> implements BackCheckService {

  @Override
  public Page<BackCheckDto> queryAllBackCheck(Page<BackCheckDto> backCheckDtoPage) {
    return null;
  }
}
