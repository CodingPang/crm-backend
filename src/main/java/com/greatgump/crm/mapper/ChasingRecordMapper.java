package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greatgump.crm.dto.ChasingAddDto;
import com.greatgump.crm.dto.FollowDetailsDto;
import com.greatgump.crm.entity.ChasingRecord;
import com.greatgump.crm.entity.Follow;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 跟进记录表 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-15 04:12:19
 */
@Mapper
public interface ChasingRecordMapper extends BaseMapper<ChasingRecord> {
    /*
    *售前跟进管理全部
    */
    List<FollowDetailsDto> queryChasingRecordAll();
    /*
     *添加跟进
     */
    void addChasing(ChasingAddDto chasingAddDto);
   /*
   *跟进记录全部
   */
   List<FollowDetailsDto> queryChasingPlans(String businessTitle);
    /*
     *跟进记录单个
     */
    FollowDetailsDto queryChasingPlan(String userName, Date progressiveTime);
}
