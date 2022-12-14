package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.Contract;
import com.greatgump.crm.mapper.ContractMapper;
import com.greatgump.crm.service.ContractService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<LuoDto2> list01() {
        return contractMapper.listBox1();
    }

    @Override
    public List<OfferListDto> searchList(OfferSearchDto offerSearchDto) {
        return contractMapper.searchList(offerSearchDto);
    }

    @Override
    public long countList(OfferSearchDto offerSearchDto) {
        return contractMapper.countList(offerSearchDto);
    }

    @Override
    public ContractUpdateDto getByIdDto(Long id) {
        return contractMapper.getByIdDto(id);
    }

    @Override
    public ContractDto getForTitle(Long id) {
        return contractMapper.getForTitle(id);
    }
}
