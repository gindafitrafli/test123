package com.project.clientfacing.loan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InstantLoanSvc implements LoanService {

    final LoanDetailRepository loanDetailRepository;


    @Override
    @Transactional
    public SubmitLoanDto submitLoan(SubmitLoanDto submitLoanDto) {
        LoanDetailModel newLoan = new LoanDetailModel();
        newLoan.setLoanAmount(submitLoanDto.loanAmount());
        newLoan.setLoanType("INSTANT");

        CustomerDetailModel customerDetailModel = new CustomerDetailModel();
        customerDetailModel.setCustomerId(submitLoanDto.customerId());
        customerDetailModel.setName(submitLoanDto.customerName());
        customerDetailModel.setIdType(submitLoanDto.customerIdType());
        customerDetailModel.setCustomerId(submitLoanDto.customerId());
        customerDetailModel.setContact(submitLoanDto.customerContact());

        newLoan.setCustomerDetail(customerDetailModel);
        customerDetailModel.setLoanDetail(newLoan);

        LoanDetailModel savedLoan = loanDetailRepository.save(newLoan);

        //send the submission to employee facing app to be checked

        return SubmitLoanDto.builder()
                .loanNumber(String.format("%s-%s", savedLoan.getLoanType(), savedLoan.getLoanId()))
                .build();
    }

    //assuming the id is always valid
    @Override
    public SubmitLoanDto getLoan(String loanNumber) {
        LoanDetailModel loanDetail = loanDetailRepository
                .findById(Integer.parseInt(loanNumber.split("-")[1]))
                .orElseThrow(() -> new RuntimeException("no data exist"));

        return SubmitLoanDto.builder()
                .loanNumber(String.format("%s-%s", loanDetail.getLoanType(), loanDetail.getLoanId()))
                .loanType(loanDetail.getLoanType())
                .customerContact(loanDetail.getCustomerDetail().getContact())
                .customerName(loanDetail.getCustomerDetail().getName())
                .customerId(loanDetail.getCustomerDetail().getCustomerId())
                .loanAmount(loanDetail.getLoanAmount())
                .build();
    }
}
