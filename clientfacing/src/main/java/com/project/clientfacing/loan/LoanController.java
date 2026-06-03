package com.project.clientfacing.loan;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/e-banking")
@Log4j2
public class LoanController {

    @PostMapping("/loan")
    void submitLoan(SubmitLoanDto submitLoanDto) {
        log.info("masuk kapten");
    }

    @GetMapping("/loan/{loanId}")
    Object getLoan(@PathVariable("loanId") String loanId) {
        log.info("bisa get kapten");
        return null;
    }
}
