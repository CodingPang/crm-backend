package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.WorkorderDto;
import com.greatgump.crm.dto.WorkorderDto2;
import com.greatgump.crm.dto.WorkorderDto3;
import com.greatgump.crm.entity.Contact;
import com.greatgump.crm.entity.Workorder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 工单 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface WorkorderMapper extends BaseMapper<Workorder> {
    Page<Workorder> queryAllWorkorder(Page page);

    Page<Workorder> queryByWorkorder(Page page,@Param("repairOrderTitle")String repairOrderTitle,@Param("workOrderStatus")Integer workOrderStatus,@Param("emergencyDegree") Integer emergencyDegree);
    boolean addWorkorder(WorkorderDto2 workorderDto2);
    List<WorkorderDto3>  queryByID(WorkorderDto3 workorderDto3);
    boolean updateByHandler(String handler);
    boolean deleteOrder(Integer id);
    boolean deletes(List<Workorder> workorders);
    Page<Workorder> getWorkorderByUid(Integer uid, Page page);
}
