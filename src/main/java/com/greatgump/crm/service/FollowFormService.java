package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greatgump.crm.dto.FollowFormAllDto;
import com.greatgump.crm.entity.FollowForm;
import com.hazelcast.core.LifecycleService;

import java.util.List;

/**
 * <p>
 * 跟进表 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-15 04:12:20
 */
public interface FollowFormService extends IService<FollowForm> {


    Page<FollowFormAllDto> listIneed(Page page);
}
