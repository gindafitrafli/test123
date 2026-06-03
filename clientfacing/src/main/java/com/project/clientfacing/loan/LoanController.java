package com.project.clientfacing.loan;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/e-banking")
@Log4j2
@RequiredArgsConstructor
public class LoanController {

    LoanService loanService;

    @PostMapping("/loan")
    SubmitLoanDto submitLoan(SubmitLoanDto submitLoanDto) {
        return loanService.submitLoan(submitLoanDto);
    }

    @GetMapping("/loan/{loanId}")
    SubmitLoanDto getLoan(@PathVariable("loanId") String loanId) {
        return loanService.getLoan(loanId);
    }
}
