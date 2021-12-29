package com.softserve.kh05802java.osbb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@Entity
@Table(name = "apartments")
@NoArgsConstructor
@Setter
@Getter
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private int number;

    @Column(name = "area")
    private double area;

    @Column(name = "number_of_residents")
    private int numberOfResidents;

    @ManyToOne
    @JoinColumn(
            name = "apartment_house_address_id",
            foreignKey = @ForeignKey(name = "apartments_apartment_house_address_id_fkey")
    )
    private ApartmentHouseAddress apartmentHouseAddress;

    @ManyToOne
    @JoinColumn(
            name = "owner_id",
            foreignKey = @ForeignKey(name = "apartments_owner_id_fkey")
    )
    private Person owner;

    @ManyToMany(mappedBy = "apartments")
    private Set<User> users;

    @ManyToMany
    @JoinTable(
            name = "apartment_service_provider",
            joinColumns = {@JoinColumn(
                    name = "apartment_id",
                    foreignKey = @ForeignKey(name = "apartment_service_provider_apartment_id_fkey")
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "service_provider_id",
                    foreignKey = @ForeignKey(name = "apartment_service_provider_service_provider_id_fkey")
            )}
    )
    private Set<ServiceProvider> serviceProviders = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apartment apartment = (Apartment) o;

        if (number != apartment.number) return false;
        return Objects.equals(apartmentHouseAddress, apartment.apartmentHouseAddress);
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (apartmentHouseAddress != null ? apartmentHouseAddress.hashCode() : 0);
        return result;
    }
}
