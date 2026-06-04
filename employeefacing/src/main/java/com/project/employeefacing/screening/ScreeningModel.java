package com.project.employeefacing.screening;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ScreeningModel {

    @Id
    String loanNumber;

    Integer loanAmount;

    String loanType;

    String screeningA;

    String screeningB;

    String customerId;

    String customerIdType;
    String customerName;
    String customerContact;

}
