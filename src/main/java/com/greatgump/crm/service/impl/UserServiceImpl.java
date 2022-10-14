package com.greatgump.crm.service.impl;

import com.greatgump.crm.entity.User;
import com.greatgump.crm.mapper.UserMapper;
import com.greatgump.crm.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
