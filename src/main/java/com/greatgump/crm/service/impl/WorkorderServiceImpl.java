package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.WorkorderDto;
import com.greatgump.crm.dto.WorkorderDto2;
import com.greatgump.crm.dto.WorkorderDto3;
import com.greatgump.crm.entity.Workorder;
import com.greatgump.crm.mapper.WorkorderMapper;
import com.greatgump.crm.service.WorkorderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    @Override
    public Page<Workorder> queryAllWorkorder(Page page) {
        return workorderMapper.queryAllWorkorder(page);
    }

    @Override
    public boolean addWorkorder(WorkorderDto2 workorderDto2) { return workorderMapper.addWorkorder(workorderDto2);
    }

    @Override
    public Page<Workorder> queryByWorkorder(Page page,String repairOrderTitle, Integer workOrderStatus, Integer emergencyDegree) {
        return workorderMapper.queryByWorkorder(page,repairOrderTitle,workOrderStatus,emergencyDegree);
    }
    @Override
    public boolean updateByhandler(String handler){
        return workorderMapper.updateByHandler(handler);
    };

    @Override
    public boolean deleteOrder(Integer id){
        return  workorderMapper.deleteOrder(id);
    };
   @Override
    public boolean deletes(List<Workorder> workorders)
   {
       return  workorderMapper.deletes(workorders);
   }
    @Override
    public List<WorkorderDto3> queryByID(WorkorderDto3 workorderDto3) {
        return workorderMapper.queryByID(workorderDto3);
    }

    @Override
    public Page<Workorder> getWorkorderByUid(Integer uid, Page page) {
        return workorderMapper.getWorkorderByUid(uid,page);
    }
}
