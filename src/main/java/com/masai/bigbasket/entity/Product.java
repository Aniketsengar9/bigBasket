package com.masai.bigbasket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @NotNull
    private  String name;
    @NotNull
    private Double price;
    @ManyToOne
    @JsonIgnore
    private Orders orders;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Supplier supplier;
    @Enumerated(EnumType.STRING)
    private Status status;
}
