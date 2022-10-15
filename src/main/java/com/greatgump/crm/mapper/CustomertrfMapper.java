package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greatgump.crm.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomertrfMapper extends BaseMapper<Dept> {

    boolean insertRecording(@Param("from")Integer from, @Param("to") Integer to);

}
