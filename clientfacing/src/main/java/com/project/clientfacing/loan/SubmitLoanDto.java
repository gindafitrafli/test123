package com.project.clientfacing.loan;

import lombok.Builder;

@Builder
public record SubmitLoanDto(
        String customerName,
        String customerContact,
        String customerID,
        String idType,
        String loanAmount,
        String loanType,
        String loanNumber
) {
}
