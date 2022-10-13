package com.greatgump.crm.mapper;

import com.greatgump.crm.entity.Source;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 客户来源 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface SourceMapper extends BaseMapper<Source> {
    List<Source> queryAllSource();

}
