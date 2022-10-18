package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.OfferDto;
import com.greatgump.crm.dto.OfferListDto;
import com.greatgump.crm.dto.OfferSearchDto;
import com.greatgump.crm.entity.Offer;
import com.greatgump.crm.entity.OfferDetails;
import com.greatgump.crm.mapper.OfferDetailsMapper;
import com.greatgump.crm.mapper.OfferMapper;
import com.greatgump.crm.service.OfferService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class OfferServiceImpl extends ServiceImpl<OfferMapper, Offer> implements OfferService {
    @Autowired
    private OfferMapper offerMapper;
    @Autowired
    private OfferDetailsMapper offerDetailsMapper;

    @Override
    public Page<OfferListDto> listIneed(Page<OfferListDto> offerListDtoPage) {
        return offerMapper.listIneed(offerListDtoPage);
    }

    @Override
    public List<OfferListDto> searchList(OfferSearchDto offerSearchDto) {
        return offerMapper.searchList(offerSearchDto);
    }

    @Override
    public Integer countList(OfferSearchDto offerSearchDto) {
        return offerMapper.countList(offerSearchDto);
    }
//    @Override
//    public boolean addAll(OfferDto offerDto) {
//        Offer offer = new Offer();
//        OfferDetails offerDetails = new OfferDetails();
//        BeanUtils.copyProperties(offerDto,offer);
//        BeanUtils.copyProperties(offerDto,offerDetails);
//        offerMapper
//        return false;
//    }
}
