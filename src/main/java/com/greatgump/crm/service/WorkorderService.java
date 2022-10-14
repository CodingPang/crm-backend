package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.WorkorderDto;
import com.greatgump.crm.dto.WorkorderDto2;
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

    int addWororder(WorkorderDto2 workorderDto2);

    Page<Workorder>  queryByWorkorder(Page page,String repairOrderTitle,Integer workOrderStatus,Integer emergencyDegree);
}

