package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.dto.ApprovalStatusDto;
import com.greatgump.crm.entity.ApprovalStatus;
import com.greatgump.crm.mapper.ApprovalStatusMapper;
import com.greatgump.crm.service.ApprovalStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalStatusServiceImpl extends ServiceImpl<ApprovalStatusMapper, ApprovalStatus> implements ApprovalStatusService {
    @Autowired
    private ApprovalStatusMapper approvalStatusMapper;

    @Override
    public List<ApprovalStatusDto> queryApprovalStatus() {

        return approvalStatusMapper.queryApprovalStatus();
    }
}
