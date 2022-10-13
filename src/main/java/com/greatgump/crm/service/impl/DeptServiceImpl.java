package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.entity.Dept;
import com.greatgump.crm.mapper.DeptMapper;
import com.greatgump.crm.service.DeptService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

}
