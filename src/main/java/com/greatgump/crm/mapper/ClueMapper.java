package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ClueReceiveDto;
import com.greatgump.crm.dto.clue.CluePreEditDto;
import com.greatgump.crm.entity.Clue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greatgump.crm.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 线索管理 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface ClueMapper extends BaseMapper<Clue> {
    boolean saveClue(ClueReceiveDto clueReceiveDto);

    boolean update( ClueReceiveDto clueReceiveDto);

//    Page<ClueReceiveDto> quryallClue(Page page);

}
