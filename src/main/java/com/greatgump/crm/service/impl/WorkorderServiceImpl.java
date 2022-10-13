package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.entity.Workorder;
import com.greatgump.crm.mapper.WorkorderMapper;
import com.greatgump.crm.service.WorkorderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工单 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class WorkorderServiceImpl extends ServiceImpl<WorkorderMapper, Workorder> implements WorkorderService {
    @Autowired
    private WorkorderMapper workorderMapper;

    public int add(Workorder workorder) {
        return workorderMapper.add(workorder);
    }
    @Override
    public Page<Workorder> queryAllWorkorder(Page page) {
        return workorderMapper.queryAllWorkorder(page);
    }
}
