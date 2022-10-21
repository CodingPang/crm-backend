package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ContractDto;
import com.greatgump.crm.entity.Contract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 合同管理 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface ContractMapper extends BaseMapper<Contract> {

    Page<ContractDto> listIneed(Page<ContractDto> offerListDtoPage);
}
