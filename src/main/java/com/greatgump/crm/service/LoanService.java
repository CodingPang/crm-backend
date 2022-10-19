package com.greatgump.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Loan;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 借款表 服务类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
public interface LoanService extends IService<Loan> {
    Page<LoanDto> queryAllLoan(Page page);

    DetailDto queryAllDetail(Integer id);

    int insertLoan(AddedLoanDto addedLoanDto);

    EditDto queryEdit(Integer id);

    int updateLoan(AddedLoanDto addedLoanDto);

    boolean deleteLoan(Integer id);

    boolean deletebatch(LoanDto loanDto);


}
