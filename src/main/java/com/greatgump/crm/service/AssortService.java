package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.AddAssortDto;
import com.greatgump.crm.dto.productlibrary.AssortDto;
import com.greatgump.crm.dto.productlibrary.QueryAssortDto;
import com.greatgump.crm.entity.Assort;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface AssortService extends IService<Assort> {
    Page<AssortDto> queryAllAssorts(Page page);

    int insertAssort(AddAssortDto addAssortDto);

    QueryAssortDto queryBid(Integer id);

}
