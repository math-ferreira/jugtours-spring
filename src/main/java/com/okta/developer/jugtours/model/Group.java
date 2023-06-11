package com.okta.developer.jugtours.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor // JPA requires a default constructor
@Table(name = "tb_group")
public class Group {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    private String address;

    private String city;

    private String stateOrProvince;

    private String country;

    private String postalCode;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "tb_group_user",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tb_group_event",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<Event> events;

    public Group(String name) {
        this.name = name;
    }
}