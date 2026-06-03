package com.project.clientfacing.loan;

public interface LoanService {
    SubmitLoanDto submitLoan(SubmitLoanDto submitLoanDto);

    SubmitLoanDto getLoan(String loanId);
}
