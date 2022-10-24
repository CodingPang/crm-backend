package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.entity.Management;
import com.greatgump.crm.entity.UploadAttachment;
import com.greatgump.crm.mapper.ManagementMapper;
import com.greatgump.crm.mapper.UploadAttachmentMapper;
import com.greatgump.crm.service.ManagementService;
import com.greatgump.crm.service.UploadAttachmentService;
import org.springframework.stereotype.Service;

@Service
public class UploadAttachmentServiceImpl extends ServiceImpl<UploadAttachmentMapper, UploadAttachment> implements UploadAttachmentService {
}
