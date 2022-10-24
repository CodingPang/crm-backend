package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greatgump.crm.dto.FollowPlan1Dto;
import com.greatgump.crm.entity.FollowPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FollowPlanMapper extends BaseMapper<FollowPlan> {
    /*
    *商机跟进计划
    */
    List<FollowPlan1Dto> queryFollowPlan(String businessTitle);
    /*
    商机跟进计划条件查询
     */
    List<FollowPlan1Dto> queryFollowPlan1(@Param("title") String title, @Param("planProgress") String planProgress);
}
