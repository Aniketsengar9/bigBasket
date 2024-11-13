package com.masai.bigbasket.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @OneToMany
    private List<Orders> ordersList = new ArrayList<>();
}
