package com.greatgump.crm.mapper;

import com.greatgump.crm.entity.Type;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 客户类型 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface TypeMapper extends BaseMapper<Type> {
    List<Type> queryAllType();
}
