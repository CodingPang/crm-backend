package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.Travel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 出差表 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface TravelService extends IService<Travel> {

    Page<TravelDto> queryAllTravel(Page page);

    TravelDetailDto queryTravelDetail(Integer id);

    int insertTravel(AddedTravelDto addedTravelDto);

    EditTravelDto queryEditTravel(Integer id);

    int updateTravel(AddedTravelDto addedTravelDto);

    List<TravelDto> queryTravelDynamic(TravelDynamicDto travelDynamicDto);
    boolean deleteTravel(Integer id);



}
