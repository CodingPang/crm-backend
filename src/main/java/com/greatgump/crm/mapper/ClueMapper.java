package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ClueDto;
import com.greatgump.crm.dto.ClueReceiveDto;
import com.greatgump.crm.dto.clue.*;
import com.greatgump.crm.dto.customerDetails.FollowPlan;
import com.greatgump.crm.entity.Clue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greatgump.crm.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 线索管理 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface ClueMapper extends BaseMapper<Clue> {
    boolean saveClue(ClueReceiveDto clueReceiveDto);

    boolean update( ClueReceiveDto clueReceiveDto);

    List<ClueDto> queryAllClue();

    List<ClueOrigin> queryAllClueOrigin();

    List<ClueStatus> queryAllClueStatus();

    List<ClueUser> queryAllClueUser();


    List<ClueContact> queryAllClueContact();

    List<ClueDept> queryAllClueDept();

    List<ClueCustomerDto> queryAllClueCustomerDto();

    List<ClueDto> selectClueDtoByCondition(@Param("username") String username,@Param("originId") Long originId, @Param("statusId") Long statusId,@Param("startDate") Date startDate,@Param("endDate") Date endDate);

    Page<ClueDto> queryListClue(Page<ClueDto> offerListDtoPage);
}
