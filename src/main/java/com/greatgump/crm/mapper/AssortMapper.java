package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.productlibrary.*;
import com.greatgump.crm.entity.Assort;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface AssortMapper extends BaseMapper<Assort> {

    Page<AssortDto> queryAllAssorts(Page page);

    int insertAssort(AddAssortDto addAssortDto);

    QueryAssortDto queryBid(Integer id);

    int updateAssort(UpdeAssortDto updeAssortDto);
}
