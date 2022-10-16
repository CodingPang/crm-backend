package com.greatgump.crm.service.impl;

import com.greatgump.crm.dto.BusinessDto;
import com.greatgump.crm.entity.Business;
import com.greatgump.crm.mapper.BusinessMapper;
import com.greatgump.crm.service.BusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商机管理 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {
    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public List<BusinessDto> listBase(int current, int size) {
        return businessMapper.listBase(current,size);
    }
}
