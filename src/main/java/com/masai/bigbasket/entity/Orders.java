package com.masai.bigbasket.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();
    @NotNull
    private LocalDate deliveryDate;
    @NotNull
    private Double totalPrice;
    @NotNull
    private Status status;
    @NotNull
    private Integer noOfProducts;
}
