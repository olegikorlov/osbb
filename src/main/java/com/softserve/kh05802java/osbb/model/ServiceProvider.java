package com.softserve.kh05802java.osbb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "service_providers")
@NoArgsConstructor
@Getter
@Setter
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "edrpou")
    private Long edrpou;

    @Column(name = "current_tariff", precision = 10, scale = 2)
    private BigDecimal currentTariff;

    @ManyToMany(mappedBy = "serviceProviders")
    private Set<Apartment> apartments = new HashSet<>();

    @OneToOne(mappedBy = "serviceProvider")
    private BankAccount bankAccount;

    @ManyToMany
    @JoinTable(name = "service_provider_personal_account",
            joinColumns = {
                    @JoinColumn(
                            name = "service_provider_id",
                            foreignKey = @ForeignKey(name = "service_provider_personal_account_service_provider_id_fkey")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "personal_account_id",
                            foreignKey = @ForeignKey(name = "service_provider_personal_account_personal_account_id_fkey")
                    )
            }
    )
    private Set<PersonalAccount> personalAccounts = new LinkedHashSet<>();

}