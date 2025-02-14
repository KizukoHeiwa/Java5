package org.java5.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Nationalized
    @Column(name = "address", nullable = false)
    private String address;

    @ColumnDefault("getdate()")
    @Column(name = "Createdate")
    private LocalDate createdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Username")
    private Account username;

    @OneToMany(mappedBy = "orderid")
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();

}