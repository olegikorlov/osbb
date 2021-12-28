package com.softserve.kh05802java.osbb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bank_accounts")
@Getter
@Setter
@NoArgsConstructor
public class BankAccount {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "mfo")
    private Long mfo;

    @Column(name = "iban")
    private String iban;

    @OneToOne(mappedBy = "bankAccount")
    private ServiceProvider serviceProvider;
}