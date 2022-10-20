package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greatgump.crm.entity.BusinessOrigin;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-20 02:08:11
 */
@Mapper
public interface BusinessOriginMapper extends BaseMapper<BusinessOrigin> {

  List<BusinessOrigin> selectAll();
}
