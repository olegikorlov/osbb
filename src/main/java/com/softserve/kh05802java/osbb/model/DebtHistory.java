package com.softserve.kh05802java.osbb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "debt_histories")
@NoArgsConstructor
@Setter
@Getter
public class DebtHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "reason", nullable = false)
    private String reason;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "debt_before", nullable = false)
    private BigDecimal before;

    @Column(name = "debt_after", nullable = false)
    private BigDecimal after;

    @ManyToMany(mappedBy = "debtHistories")
    private Set<PersonalAccount> personalAccounts = new HashSet<>();

}
