package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ContactDto;
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
    Page<ContactDto> queryAllContact(Page page);
    ContactDto queryContactById(Integer id);
    Page<ContactDto>  queryContactDynamic(String keywords,Page page);
    int updateContact(Contact contact);
    int saveContact(Contact contact);
    int deleteById(Integer id);
    int updateCustomerById(Contact contact);
    Contact queryOne(Integer id);
}
