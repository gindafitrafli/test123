package com.project.clientfacing.loan;

import lombok.Builder;

@Builder
public record SubmitLoanDto(
        String customerName,
        String customerContact,
        String customerId,
        String idType,
        Integer loanAmount,
        String loanType,
        String loanNumber
) {
}
