package com.softserve.kh05802java.osbb.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@Entity
@Table(name = "apartment")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "owner_id", foreignKey=@ForeignKey(name="apartment_owner_id_fkey"))
    private Person owner;

    @Column(name = "area")
    private double area;

    @Column(name = "number_of_residents")
    private int numberOfResidents;
}
