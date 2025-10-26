package com.bigbasket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    @JoinColumn(name = "category_id")
    private Category category;

//    @ManyToOne
//    private Supplier supplier;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Integer quantity;

    @PrePersist
    @PreUpdate
    private void validateAndSetDefault(){
        if(quantity < 0){
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if(status==null){
            status = Status.INSTOCK;
        }
    }

}
