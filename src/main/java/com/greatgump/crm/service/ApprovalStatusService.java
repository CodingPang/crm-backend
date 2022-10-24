package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.greatgump.crm.dto.ApprovalStatusDto;
import com.greatgump.crm.dto.LoanOrderDto;
import com.greatgump.crm.entity.ApprovalStatus;

import java.util.List;

public interface ApprovalStatusService  extends IService<ApprovalStatus> {


    List<ApprovalStatusDto> queryApprovalStatus();

}
