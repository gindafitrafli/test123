package com.project.employeefacing.screening;

import com.project.employeefacing.screening.Integration.ScreeningTopicProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class ScreeningServiceImpl implements ScreeningService{

    final ScreeningRepository screeningRepository;
    final ScreeningTopicProducer screeningPublisher;

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void submitLoanScreening(ScreeningDto screeningDto) {
        ScreeningModel screeningModel = new ScreeningModel();
        screeningModel.setCustomerId(screeningDto.customerId());
        screeningModel.setLoanAmount(screeningDto.loanAmount());
        screeningModel.setLoanType(screeningDto.loanType());
        screeningModel.setCustomerIdType(screeningDto.customerIdType());
        screeningModel.setLoanNumber(screeningDto.loanNumber());
        screeningModel.setCustomerContact(screeningDto.customerContact());
        screeningModel.setCustomerName(screeningDto.customerName());

        screeningRepository.save(screeningModel);

        screeningPublisher.publish(screeningDto);
    }

    @Override
    public void getLoanScreening(String fromDate, String loanNumber) {

    }
}
