package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.entity.Contact;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 企业联系人表 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface ContactService extends IService<Contact> {
    Page<Contact> queryAllContact(Page page);
    int saveContact(Contact contact);

    Contact queryOne(Integer id);
}
