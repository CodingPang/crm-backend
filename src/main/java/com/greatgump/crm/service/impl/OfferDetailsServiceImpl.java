package com.greatgump.crm.service.impl;

import com.greatgump.crm.entity.OfferDetails;
import com.greatgump.crm.mapper.OfferDetailsMapper;
import com.greatgump.crm.service.OfferDetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class OfferDetailsServiceImpl extends ServiceImpl<OfferDetailsMapper, OfferDetails> implements OfferDetailsService {
    @Autowired
    private OfferDetailsMapper offerDetailsMapper;

    @Override
    public int countNumber() {

        return offerDetailsMapper.countNumber();
    }

    @Override
    public double totalMoney() {
        return offerDetailsMapper.totalMoney();
    }

    @Override
    public List<OfferDetails> listBycompany(int id, int current,int size) {
        return offerDetailsMapper.listBycompany(id,current,size);
    }

    @Override
    public Long listBycompanyCount(int id) {
        return offerDetailsMapper.listBycompanyCount(id);
    }

    @Override
    public List<OfferDetails> listBycompanyUpdate(int id, int current, int size, int orderid) {
        return offerDetailsMapper.listBycompanyUpdate(id,current,size,orderid);
    }

    @Override
    public Long listBycompanyCountUpdate(int id, int orderid) {
        return offerDetailsMapper.listBycompanyCountUpdate(id,orderid);
    }
}
