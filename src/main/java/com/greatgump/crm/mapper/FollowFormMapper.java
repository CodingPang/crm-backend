package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.FollowFormAllDto;
import com.greatgump.crm.entity.FollowForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

    Page<FollowFormAllDto> listIneed(Page page);
}
