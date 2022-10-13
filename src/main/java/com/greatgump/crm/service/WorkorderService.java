package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.entity.Contact;
import com.greatgump.crm.entity.Workorder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 工单 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface WorkorderService extends IService<Workorder> {
    int add(Workorder workorder);
    Page<Workorder> queryAllWorkorder(Page page);

}
