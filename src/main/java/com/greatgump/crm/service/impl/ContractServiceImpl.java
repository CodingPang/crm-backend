package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ContractDto;
import com.greatgump.crm.entity.Contract;
import com.greatgump.crm.mapper.ContractMapper;
import com.greatgump.crm.service.ContractService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 合同管理 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements ContractService {
    @Autowired
    private ContractMapper contractMapper;
    @Override
    public Page<ContractDto> listIneed(Page<ContractDto> offerListDtoPage) {
        return contractMapper.listIneed(offerListDtoPage);
    }
}
