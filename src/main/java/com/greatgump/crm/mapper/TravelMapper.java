package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.Travel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 出差表 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface TravelMapper extends BaseMapper<Travel> {

    Page<TravelDto> queryAllTravels(Page page);

    TravelDetailDto queryTravelDetails(Integer id);

    int insertTravel(AddedTravelDto addedTravelDto);

    EditTravelDto queryEditTravel(Integer id);

    int updateTravel(AddedTravelDto addedTravelDto);

    boolean deleteTravel(Integer id);

    boolean deletebatch(TravelDto travelDto);


}
