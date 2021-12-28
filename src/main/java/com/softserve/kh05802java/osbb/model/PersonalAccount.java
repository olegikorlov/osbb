package com.softserve.kh05802java.osbb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personal_accounts")
@NoArgsConstructor
@Setter
@Getter
@ToString
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
            joinColumns = { @JoinColumn(name = "debt_history_id") },
            inverseJoinColumns = { @JoinColumn(name = "personal_account_id") })
    private Set<DebtHistory> products = new HashSet<DebtHistory>();
}
