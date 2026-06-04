package com.project.employeefacing.screening;

public record ScreeningDto(
        String customerName,
        String customerContact,
        String customerId,
        String customerIdType,
        Integer loanAmount,
        String loanType,
        String loanNumber) {
}
