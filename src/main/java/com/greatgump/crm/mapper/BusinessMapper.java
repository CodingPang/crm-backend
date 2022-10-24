package com.greatgump.crm.mapper;

import com.greatgump.crm.dto.BusinessDto;
import com.greatgump.crm.dto.BusinessTitleDto;
import com.greatgump.crm.dto.LoanBusinessDto;
import com.greatgump.crm.dto.LoanOrderDto;
import com.greatgump.crm.dto.finance.cost.BusinessListDto;
import com.greatgump.crm.entity.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 商机管理 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface BusinessMapper extends BaseMapper<Business> {

    List<BusinessDto> listBase(int current, int size);

  /**
   * 查询出所有的商机
   * @return
   */
  List<BusinessListDto> selectAllBusiness();

    List<LoanBusinessDto> queryBusiness();

    List<BusinessTitleDto> listTitle();
}
