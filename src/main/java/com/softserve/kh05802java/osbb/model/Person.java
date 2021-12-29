package com.softserve.kh05802java.osbb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@Entity
@Table(name = "persons")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName = "";

    @Column(name = "middle_name", nullable = false)
    private String middleName = "";

    @Column(name = "last_name", nullable = false)
    private String lastName = "";

    @OneToMany(mappedBy = "owner")
    private Set<Apartment> apartments;

}
