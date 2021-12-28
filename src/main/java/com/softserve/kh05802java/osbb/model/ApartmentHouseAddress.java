package com.softserve.kh05802java.osbb.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@Entity
@Table(name = "apartment_house_addresses")
public class ApartmentHouseAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "building", nullable = false)
    private String building;

    @OneToMany(mappedBy = "apartmentHouseAddress")
    private Set<Apartment> apartments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApartmentHouseAddress that = (ApartmentHouseAddress) o;

        if (!Objects.equals(city, that.city)) return false;
        if (!Objects.equals(street, that.street)) return false;
        return Objects.equals(building, that.building);
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (building != null ? building.hashCode() : 0);
        return result;
    }

}
