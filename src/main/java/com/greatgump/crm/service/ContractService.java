package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ContractDto;
import com.greatgump.crm.dto.LuoDto2;
import com.greatgump.crm.entity.Contract;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 合同管理 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface ContractService extends IService<Contract> {

    Page<ContractDto> listIneed(Page<ContractDto> offerListDtoPage);

    List<LuoDto2> list01();
}
