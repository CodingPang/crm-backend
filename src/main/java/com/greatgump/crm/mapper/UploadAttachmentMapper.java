package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greatgump.crm.dto.UplodeEnclosureDto;
import com.greatgump.crm.entity.UploadAttachment;

import java.util.List;

public interface UploadAttachmentMapper extends BaseMapper<UploadAttachment> {
    List<UplodeEnclosureDto> queryEnclosure(String businessTitle);
}
