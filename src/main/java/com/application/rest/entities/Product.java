package com.application.rest.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

// lombok
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
// jpa
@Entity
@Table(name = "producto")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    // big decimal es para trabajar con decimales y con monedas o dinero
    // decimal de alta precisión
    @Column(name = "precio")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fabricante_id", nullable = false)
    @JsonIgnore
    private Maker maker;
}
