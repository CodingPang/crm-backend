package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ClueDto;
import com.greatgump.crm.dto.ClueReceiveDto;
import com.greatgump.crm.dto.CustomerBaseDto;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.entity.Clue;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 * 线索管理 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface ClueService extends IService<Clue> {
        Page<ClueReceiveDto> quryallClue(Page page);

    boolean saveClue(ClueReceiveDto clueReceiveDto);

   boolean update( ClueReceiveDto clueReceiveDto);
       boolean lookup( ClueReceiveDto clueReceiveDto);




}
