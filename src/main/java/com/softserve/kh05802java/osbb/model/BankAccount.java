package com.softserve.kh05802java.osbb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bank_accounts")
@NoArgsConstructor
@Getter
@Setter
public class BankAccount {

    @Id
    private Long id;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "mfo")
    private Long mfo;

    @Column(name = "iban")
    private String iban;

    @OneToOne
    @JoinColumn(
            name = "id",
            foreignKey = @ForeignKey(name = "bank_accounts_id_fkey")
    )
    @MapsId
    private ServiceProvider serviceProvider;

}