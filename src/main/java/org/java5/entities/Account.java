package org.java5.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    @Size(max = 255)
    @Column(name = "username", nullable = false)
    private String username;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Size(max = 255)
    @NotNull
    @Nationalized
    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @Size(max = 255)
    @Nationalized
    @Column(name = "photo")
    private String photo;

    @Column(name = "activated")
    private Boolean activated;

    @Column(name = "admin")
    private Boolean admin;

    @OneToMany(mappedBy = "username")
    private Set<org.java5.entities.Order> orders = new LinkedHashSet<>();

}