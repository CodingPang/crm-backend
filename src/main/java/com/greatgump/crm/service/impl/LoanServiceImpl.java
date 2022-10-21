package com.greatgump.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatgump.crm.dto.*;
import com.greatgump.crm.entity.Loan;
import com.greatgump.crm.mapper.LoanMapper;
import com.greatgump.crm.service.LoanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 借款表 服务实现类
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Service
public class LoanServiceImpl extends ServiceImpl<LoanMapper, Loan> implements LoanService {
    @Autowired
    private LoanMapper loanMapper;

    @Override
    public Page<LoanDto> queryAllLoan(Page page) {
        Page<LoanDto> loanDtoPage = loanMapper.queryAllloans(page);

        return loanDtoPage;
    }

    @Override
    public DetailDto queryAllDetail(Integer id) {
        return loanMapper.queryAllDetails(id);
    }

    @Override
    public int insertLoan(AddedLoanDto addedLoanDto) {
        return loanMapper.insertLoan(addedLoanDto);
    }

    @Override
    public EditDto queryEdit(Integer id) {
        return loanMapper.queryEdit(id);
    }

    @Override
    public List<LoanDto> queryLoanDynamic(LoanDynamicDto loanDynamicDto) {

        return loanMapper.queryLoanDynamic(loanDynamicDto);
    }

    @Override
    public int updateLoan(AddedLoanDto addedLoanDto) {
        return loanMapper.updateLoan(addedLoanDto);
    }

    @Override
    public boolean deleteLoan(Long id) {
        boolean b = loanMapper.deleteLoan(id);
        return b;
    }

    @Override
    public boolean deleteBatch(List<Long> ids) {
        return loanMapper.deleteBatch(ids);
    }
}
