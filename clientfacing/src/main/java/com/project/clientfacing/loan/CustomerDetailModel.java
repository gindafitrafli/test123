package com.project.clientfacing.loan;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerDetailModel {

    @Id
    Integer loanId;
    String name;
    String contact;
    String customerId;
    String idType;

    @OneToOne(mappedBy = "customerDetail")
    @MapsId
    @JoinColumn(name = "loanId")
    LoanDetailModel loanDetail;
}
