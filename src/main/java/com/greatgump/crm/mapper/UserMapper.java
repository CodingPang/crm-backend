package com.greatgump.crm.mapper;

import com.greatgump.crm.dto.UserDto0;
import com.greatgump.crm.dto.finance.cost.PrincipalDto;
import com.greatgump.crm.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> queryAllUserName();
    User queryUserById(Integer id);

    List<UserDto0> getName();

  /**
   * 查询所有的费用记录负责人员
   * @return
   */
  List<PrincipalDto> queryAllPrincipalDto();
}
