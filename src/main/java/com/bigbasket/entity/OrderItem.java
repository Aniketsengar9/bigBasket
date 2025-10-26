package com.bigbasket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name ="orderId")
    @JsonBackReference
    private Orders order;

    @ManyToOne
    @JoinColumn(name ="userId")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="productId")
    private Product product;

    private Integer quantity;
    private Double price;
}

