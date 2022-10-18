package com.greatgump.crm.service.impl;

import com.greatgump.crm.dto.UserDto0;
import com.greatgump.crm.entity.User;
import com.greatgump.crm.mapper.UserMapper;
import com.greatgump.crm.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserDto0> getName() {
        return userMapper.getName();
    }
}
