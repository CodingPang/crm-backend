package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.dto.ClueReceiveDto;
import com.greatgump.crm.entity.FollowForm;
import com.greatgump.crm.mapper.CustomerMapper;
import com.greatgump.crm.mapper.FollowFormMapper;
import com.greatgump.crm.service.FollowFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 跟进表 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-15 04:12:20
 */
@Service
public class FollowFormServiceImpl extends ServiceImpl<FollowFormMapper, FollowForm> implements FollowFormService {

@Autowired
private FollowFormMapper followFormMapper;


    }

