package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.ContactDto;
import com.greatgump.crm.entity.Contact;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 企业联系人表 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface ContactMapper extends BaseMapper<Contact> {
    Page<ContactDto> queryAllContact(Page page);
    int saveContact(Contact contact);

    int deleteById(Integer id);
    int updateIsDefaultByCid(Integer cid);

    int updateContact(Contact contact);
    Page<ContactDto>  queryContactDynamic(String keywords,Page page);
    ContactDto queryContactById(Integer id);
    Contact queryDefByCustomerIdContact(Integer cid);

    Contact queryOne(@Param("id") Integer id);
}
