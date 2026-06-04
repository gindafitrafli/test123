package com.project.employeefacing.screening;

public interface ScreeningService {
    void submitLoanScreening(ScreeningDto screeningDto);

    void getLoanScreening(String fromDate, String loanNumber);
}
