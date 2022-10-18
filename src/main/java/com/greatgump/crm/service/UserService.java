package com.greatgump.crm.service;

import com.greatgump.crm.dto.UserDto0;
import com.greatgump.crm.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.awt.*;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface UserService extends IService<User> {

    List<UserDto0> getName();
}
