package com.greatgump.crm.mapper;

import com.greatgump.crm.dto.LuoDto1;
import com.greatgump.crm.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 产品库 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    List<LuoDto1> listIneed();

    List<LuoDto1> listIneed(@Param("current")int current, @Param("size")int size);
}
