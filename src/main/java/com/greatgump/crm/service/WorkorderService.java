package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.WorkorderDto;
import com.greatgump.crm.dto.WorkorderDto2;
import com.greatgump.crm.dto.WorkorderDto3;
import com.greatgump.crm.entity.Contact;
import com.greatgump.crm.entity.Workorder;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 工单 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface WorkorderService extends IService<Workorder> {
    Page<Workorder> queryAllWorkorder(Page page);
    boolean addWorkorder(WorkorderDto2 workorderDto2);
    Page<Workorder>  queryByWorkorder(Page page,String repairOrderTitle,Integer workOrderStatus,Integer emergencyDegree);
    boolean updateByhandler(String handler);
    boolean deleteOrder(Integer id);
    boolean deletes(List<Workorder> workorders);
    List<WorkorderDto3>  queryByID(WorkorderDto3 workorderDto3);
    Page<Workorder> getWorkorderByUid(Integer uid,Page page);
}

