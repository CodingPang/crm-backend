package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.entity.Contact;
import com.greatgump.crm.mapper.ContactMapper;
import com.greatgump.crm.service.ContactService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 企业联系人表 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements ContactService {
    @Autowired
    private ContactMapper contactMapper;
    @Override
    public Page<Contact> queryAllContact(Page page) {
        return contactMapper.queryAllContact(page);
    }

    @Override
    public int saveContact(Contact contact) {
        return contactMapper.saveContact(contact);
    }
}
