package com.masai.bigbasket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;
    @NotNull
    private String supplierName;
    @NotNull
    private Integer Contact;
    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> productList = new ArrayList<>();
}
