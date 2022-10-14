package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.WorkorderDto;
import com.greatgump.crm.dto.WorkorderDto2;
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

    int addWorkorder(WorkorderDto2 workorderDto2);

    Page<Workorder> queryByWorkorder(Page page,@Param("repairOrderTitle")String repairOrderTitle,@Param("workOrderStatus")Integer workOrderStatus,@Param("emergencyDegree") Integer emergencyDegree);
}
