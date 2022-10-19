package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ContactDto;
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
    public Page<ContactDto> queryAllContact(Page page) {
        return contactMapper.queryAllContact(page);
    }

    @Override
    public ContactDto queryContactById(Integer id) {
        return contactMapper.queryContactById(id);
    }

    @Override
    public Page<ContactDto> queryContactDynamic(String keywords,Page page) {
        return contactMapper.queryContactDynamic(keywords,page);
    }

    @Override
    public int updateContact(Contact contact) {
        return contactMapper.updateContact(contact);
    }

    @Override
    public int saveContact(Contact contact) {
            contactMapper.updateIsDefaultByCid(contact.getCustomerId());
        return contactMapper.saveContact(contact);
    }

    @Override
    public int deleteById(Integer id) {
        return contactMapper.deleteById(id);
    }

    @Override
    public int updateCustomerById(Contact contact) {
        return contactMapper.updateCustomerById(contact);
    }


    @Override
    public Contact queryOne(Integer id) {
        return contactMapper.queryOne(id);
    }
}
