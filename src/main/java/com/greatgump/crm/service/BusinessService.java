package com.greatgump.crm.service;

import com.greatgump.crm.dto.BusinessDto;
import com.greatgump.crm.dto.LoanBusinessDto;
import com.greatgump.crm.entity.Business;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商机管理 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface BusinessService extends IService<Business> {


    List<BusinessDto> listBase(int current, int size);

    List<LoanBusinessDto> queryBusiness();
}
