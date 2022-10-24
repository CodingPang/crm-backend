package com.greatgump.crm.service;

import com.greatgump.crm.dto.OfferDetailsUpdateListDto;
import com.greatgump.crm.entity.OfferDetails;
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
public interface OfferDetailsService extends IService<OfferDetails> {


    int countNumber();

    double totalMoney();

    List<OfferDetails> listBycompany(int id, int current,int size);

    Long listBycompanyCount(int id);

    List<OfferDetails> listBycompanyUpdate(OfferDetailsUpdateListDto dto);

    Long listBycompanyCountUpdate(OfferDetailsUpdateListDto dto);
}
