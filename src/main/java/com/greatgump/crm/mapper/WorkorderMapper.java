package com.greatgump.crm.mapper;

import com.greatgump.crm.entity.Workorder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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
    public int add(Workorder workorder);

}
