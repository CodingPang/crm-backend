package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greatgump.crm.entity.Invoice;
import com.greatgump.crm.mapper.InvoiceMapper;
import com.greatgump.crm.service.InvoiceService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 发票 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@Service
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements InvoiceService {

}
