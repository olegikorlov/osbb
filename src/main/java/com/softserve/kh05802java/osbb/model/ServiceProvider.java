package com.softserve.kh05802java.osbb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "service_providers")
@Getter
@Setter
@NoArgsConstructor
public class ServiceProvider {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "edrpou")
    private Long edrpou;

    @Column(name = "current_tariff", precision = 10, scale = 2)
    private BigDecimal currentTariff;

    @ManyToMany(mappedBy = "serviceProviders")
    private Set<Apartment> apartments = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private BankAccount bankAccount;
}