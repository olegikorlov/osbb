package com.softserve.kh05802java.osbb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personal_accounts")
@NoArgsConstructor
@Setter
@Getter
public class PersonalAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "debt_amount", nullable = false)
    private BigDecimal debtAmount;

    @ManyToMany
    @JoinTable(name = "personal_account_debt_history",
            joinColumns = {
                    @JoinColumn(
                            name = "personal_account_id",
                            foreignKey = @ForeignKey(name = "personal_account_debt_history_personal_account_id_fkey")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "debt_history_id",
                            foreignKey = @ForeignKey(name = "personal_account_debt_history_debt_history_id_fkey")
                    )
            })
    private Set<DebtHistory> debtHistories = new HashSet<>();

    @ManyToMany(mappedBy = "personalAccounts")
    private Set<ServiceProvider> serviceProviders;
}
