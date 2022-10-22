package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.OfferListDto;
import com.greatgump.crm.dto.OfferSearchDto;
import com.greatgump.crm.dto.OrderFollowDto;
import com.greatgump.crm.entity.Offer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface OfferMapper extends BaseMapper<Offer> {
    Page<OfferListDto> listIneed(Page<OfferListDto> offerListDtoPage);

    List<OfferListDto> searchList(OfferSearchDto offerSearchDto);

    Integer countList(OfferSearchDto offerSearchDto);



    /*
    *商机中关联订单跟进
    */
    OrderFollowDto addOrderFollow(Long id);
}
