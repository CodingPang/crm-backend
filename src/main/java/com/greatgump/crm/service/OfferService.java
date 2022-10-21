package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.OfferListDto;
import com.greatgump.crm.dto.OfferSearchDto;
import com.greatgump.crm.dto.OfferUpdateDto;
import com.greatgump.crm.entity.Offer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface OfferService extends IService<Offer> {
    Page<OfferListDto> listIneed(Page<OfferListDto> offerListDtoPage);

    List<OfferListDto> searchList(OfferSearchDto offerSearchDto);

    Integer countList(OfferSearchDto offerSearchDto);

    OfferUpdateDto getByIdDto(Long id);

//    boolean addAll(OfferDto offerDto);
}
