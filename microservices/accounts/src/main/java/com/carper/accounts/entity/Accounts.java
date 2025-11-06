package com.carper.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Accounts extends BaseEntity {

    @Id
    @Column(name="account_number")
    public Long accountNumber;

    @Column(name="customer_id")
    public Long customerId;

    @Column(name="account_type")
    public String accountType;

    @Column(name="branch_address")
    public String branchAddress;

}
