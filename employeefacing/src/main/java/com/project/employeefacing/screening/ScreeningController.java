package com.project.employeefacing.screening;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/screening")
@RequiredArgsConstructor
@Log4j2
public class ScreeningController {

    final ScreeningService screeningService;

    @PostMapping(value = "/loan")
    void submitLoanScreening (@RequestBody ScreeningDto screeningDto) {
        screeningService.submitLoanScreening(screeningDto);
    }

    @GetMapping(value = "/loan")
    void getLoanScreening (@RequestParam("fromDate") String fromDate, @RequestParam("loanNumber") String loanNumber) {
        screeningService.getLoanScreening(fromDate, loanNumber);
    }
}
