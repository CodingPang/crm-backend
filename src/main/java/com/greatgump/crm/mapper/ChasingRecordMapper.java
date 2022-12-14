package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greatgump.crm.dto.businessDto.ChasingAddDto;
import com.greatgump.crm.dto.FollowDetailsDto;
import com.greatgump.crm.dto.chasing.ChasingMethodDto;
import com.greatgump.crm.dto.chasing.ChasingRecordDto;
import com.greatgump.crm.dto.clue.ClueCustomerDto;
import com.greatgump.crm.entity.ChasingRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
//    void addChasingRecord(ChasingRecord chasingRecord);

    List<ChasingMethodDto> queryAllChasingMethod();


    void addChasingRecord(ChasingRecord chasingRecord);

    List<ChasingRecordDto> queryAllChasingRecords();

    void addChasingRecordByCustomerId(ChasingRecord chasingRecord);

    List<ClueCustomerDto> queryAllCustomer();

    List<ChasingRecordDto> queryChasingRecords();


    List<FollowDetailsDto> queryChasingPlans(String businessTitle);

    FollowDetailsDto queryChasingPlan(@Param("userName") String userName, @Param("progressiveTime") String progressiveTime);

    void saveChasing(ChasingAddDto chasingAddDto);

}
