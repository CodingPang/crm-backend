package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ClueReceiveDto;
import com.greatgump.crm.dto.clue.CluePreEditDto;
import com.greatgump.crm.entity.FollowForm;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 跟进表 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-15 04:12:20
 */
@Mapper
public interface FollowFormMapper extends BaseMapper<FollowForm> {

  /**
   * 新增线索
   * @param clueReceiveDto
   * @return
   */
  boolean insertClue(ClueReceiveDto clueReceiveDto);

  /**
   * 编辑/更新线索
   * @param clueReceiveDto
   * @return
   */
  boolean updateClue(ClueReceiveDto clueReceiveDto);

  /**
   * 1、根据id查询这条数据在线索表的记录
   * @param id
   * @return
   */
  CluePreEditDto selectOneClue(Integer id);
}
