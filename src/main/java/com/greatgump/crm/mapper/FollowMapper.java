package com.greatgump.crm.mapper;

import com.greatgump.crm.dto.businessDto.OrderFollowDto;
import com.greatgump.crm.entity.Follow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface FollowMapper extends BaseMapper<Follow> {


    /*
     *商机中关联订单跟进
     */
    OrderFollowDto saveOrderFollow(Long id);


}
