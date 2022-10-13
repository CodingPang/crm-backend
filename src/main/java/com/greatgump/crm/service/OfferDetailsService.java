package com.greatgump.crm.service;

import com.greatgump.crm.entity.OfferDetails;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
