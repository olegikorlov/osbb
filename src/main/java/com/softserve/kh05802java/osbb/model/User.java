package com.softserve.kh05802java.osbb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "users_login_key", columnNames = "login")
        })
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}", message = "Must be a valid e-mail address")
    @Column(name = "login", nullable = false)
    private String login;

    //    @Pattern(regexp = "(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}",
//            message = "Must be minimum 6 characters, at least one letter and one number")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName = "";

    @Column(name = "last_name", nullable = false)
    private String lastName = "";

    @ManyToOne
    @JoinColumn(
            name = "role_id",
            foreignKey = @ForeignKey(name = "users_role_id_fkey")
    )
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "user_apartment",
            joinColumns = {@JoinColumn(
                    name = "user_id",
                    foreignKey = @ForeignKey(name = "user_apartment_user_id_fkey")
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "apartment_id",
                    foreignKey = @ForeignKey(name = "user_apartment_apartment_id_fkey")
            )}
    )
    private Set<Apartment> apartments = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Contact> contacts;

    public void addApartment(Apartment apartment) {
        this.apartments.add(apartment);
        apartment.getUsers().add(this);
    }

    public void removeApartment(Apartment apartment) {
        this.apartments.remove(apartment);
        apartment.getUsers().remove(this);
    }

    public User(String login, String firstName, String lastName) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
