package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greatgump.crm.dto.ApprovalStatusDto;
import com.greatgump.crm.entity.ApprovalStatus;

import java.util.List;

public interface ApprovalStatusMapper extends BaseMapper<ApprovalStatus> {

    List<ApprovalStatusDto> queryApprovalStatus();
}
