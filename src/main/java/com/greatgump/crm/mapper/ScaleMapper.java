package com.greatgump.crm.mapper;

import com.greatgump.crm.entity.Scale;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 企业规模表 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface ScaleMapper extends BaseMapper<Scale> {
        List<Scale> queryAllScale();

}
