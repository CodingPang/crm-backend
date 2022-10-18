package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    Page<Contact> queryAllContact(Page page);
    int saveContact(Contact contact);

    Contact queryDefByCustomerIdContact(Integer cid);


    Contact queryOne(@Param("id") Integer id);
}
