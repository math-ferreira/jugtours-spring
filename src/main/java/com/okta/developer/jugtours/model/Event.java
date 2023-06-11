package com.okta.developer.jugtours.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor // JPA requires a default constructor
@Table(name = "tb_event")
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private Instant date;

    private String title;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "tb_event_user",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

    public Event(Instant date, String title, String description) {
        this.date = date;
        this.title = title;
        this.description = description;
    }
}