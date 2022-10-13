package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greatgump.crm.entity.Invoice;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 发票 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Mapper
public interface InvoiceMapper extends BaseMapper<Invoice> {

}
