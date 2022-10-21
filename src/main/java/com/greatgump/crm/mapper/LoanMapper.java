package com.greatgump.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Loan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.rmi.server.UID;
import java.util.List;

/**
 * <p>
 * 借款表 Mapper 接口
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Mapper
public interface LoanMapper extends BaseMapper<Loan> {
      Page<LoanDto> queryAllloans(Page page);

      DetailDto queryAllDetails(Integer id);

      int insertLoan(AddedLoanDto addedLoanDto);

      EditDto queryEdit(Integer id);

      int updateLoan(AddedLoanDto addedLoanDto);

      List<LoanDto> queryLoanDynamic(LoanDynamicDto loanDynamicDto);

      boolean deleteLoan(Long id);

      boolean deleteBatch(@Param("ids") List<Long> ids);


}
