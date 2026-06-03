package com.project.clientfacing.loan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstantLoanSvc implements LoanService{

    LoanDetailRepository loanDetailRepository;


    @Override
    public SubmitLoanDto submitLoan(SubmitLoanDto submitLoanDto) {
        return null;
    }

    @Override
    public SubmitLoanDto getLoan(String loanId) {
        return null;
    }
}
