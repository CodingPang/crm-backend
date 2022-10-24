package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greatgump.crm.dto.ClueReceiveDto;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ClueReceiveDtoMapper extends BaseMapper<ClueReceiveDto> {

    Integer addContact(ClueReceiveDto ClueReceiveDto);

    Integer addFollowForm(ClueReceiveDto clueReceiveDto);
    
    

    ClueReceiveDto editPreClueReceive(Long id);

    void updateClueReceiveByClueReceiveDto(ClueReceiveDto clueReceiveDto);

    void deleteClueById(Long id);

//    ClueReceiveDto selectClueReceiveDtoByCondition(@Param("username") String username,@Param("originId") Long originId,@Param("statusId") Long statusId,@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    void addChasingRecord(ClueReceiveDto clueReceiveDto);
}
