package com.greatgump.crm.service.impl;

import com.greatgump.crm.entity.Type;
import com.greatgump.crm.mapper.TypeMapper;
import com.greatgump.crm.service.TypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户类型 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

}
