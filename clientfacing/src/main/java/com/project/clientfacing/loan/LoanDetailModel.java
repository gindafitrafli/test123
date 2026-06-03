package com.project.clientfacing.loan;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

@Entity
@Getter
@Setter
public class LoanDetailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer loanId;
    Integer loanAmount;
    String loanType;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "loanDetail")
    CustomerDetailModel customerDetail;

}
