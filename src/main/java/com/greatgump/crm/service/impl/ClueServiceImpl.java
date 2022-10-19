package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ClueDto;
import com.greatgump.crm.dto.ClueReceiveDto;
import com.greatgump.crm.dto.clue.CluePreEditDto;
import com.greatgump.crm.entity.Clue;
import com.greatgump.crm.mapper.ClueMapper;
import com.greatgump.crm.mapper.FollowFormMapper;
import com.greatgump.crm.service.ClueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 线索管理 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class ClueServiceImpl extends ServiceImpl<ClueMapper, Clue> implements ClueService {

      @Autowired
      private FollowFormMapper followFormMapper;


    @Override
    public Page<ClueReceiveDto> quryallClue(Page page) {
        return null;
    }

    @Override
    public boolean saveClue(ClueReceiveDto clueReceiveDto) {
        return followFormMapper.insertClue(clueReceiveDto);
    }

    @Override
    public boolean update(ClueReceiveDto clueReceiveDto) {
        return followFormMapper.updateClue(clueReceiveDto);
    }

    @Override
    public boolean lookup(ClueReceiveDto clueReceiveDto) {
        return false;
    }

    @Override
    public CluePreEditDto queryOneClue(Integer id) {
        return followFormMapper.selectOneClue(id);
    }
}


