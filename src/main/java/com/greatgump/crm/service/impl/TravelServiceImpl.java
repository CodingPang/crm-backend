package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.Travel;
import com.greatgump.crm.mapper.TravelMapper;
import com.greatgump.crm.service.TravelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 出差表 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class TravelServiceImpl extends ServiceImpl<TravelMapper, Travel> implements TravelService {

    @Autowired
    private TravelMapper travelMapper;


    @Override
    public Page<TravelDto> queryAllTravel(Page page) {

        return travelMapper.queryAllTravels(page);
    }

    @Override
    public TravelDetailDto queryTravelDetail(Integer id) {

        return travelMapper.queryTravelDetails(id);

    }

    @Override
    public int insertTravel(AddedTravelDto addedTravelDto) {
        return travelMapper.insertTravel(addedTravelDto);
    }

    @Override
    public EditTravelDto queryEditTravel(Integer id) {
        return travelMapper.queryEditTravel(id);
    }

    @Override
    public int updateTravel(AddedTravelDto addedTravelDto) {

        return travelMapper.updateTravel(addedTravelDto);
    }

    @Override
    public List<TravelDto> queryTravelDynamic(TravelDynamicDto travelDynamicDto) {

        return travelMapper.queryTravelDynamic(travelDynamicDto);
    }

    @Override
    public boolean deleteTravel(Integer id) {
        boolean b = travelMapper.deleteTravel(id);
        return b;
    }

}
