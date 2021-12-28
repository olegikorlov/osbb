package com.softserve.kh05802java.osbb.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "bills")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "formation_date")
    private Instant formationDate;

    @Column(name = "purpose_of_payment")
    private String purposeOfPayment;

    @Column(name = "period")
    private Instant period;

    @Column(name = "amount", precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "tariff", precision = 10, scale = 2)
    private BigDecimal tariff;
}