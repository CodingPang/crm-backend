package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.greatgump.crm.entity.Workorder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_workorder(工单)】的数据库操作Mapper
* @createDate 2022-10-20 14:08:35
* @Entity com.greatgump.crm.entity.Workorder
*/
public interface WorkorderMapper extends BaseMapper<Workorder> {
    IPage<Workorder> queryByPage(IPage<Workorder> page, @Param(Constants.WRAPPER) Wrapper<Workorder> wrapper);
    Workorder mySelectById( @Param(Constants.WRAPPER) Wrapper<Workorder> wrapper);
}




