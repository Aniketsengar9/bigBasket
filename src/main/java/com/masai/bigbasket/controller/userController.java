package com.masai.bigbasket.controller;

import com.masai.bigbasket.entity.Orders;

import com.masai.bigbasket.entity.Product;
import com.masai.bigbasket.entity.User;
import com.masai.bigbasket.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {
    @Autowired
    private userService service;

    @PostMapping("/users")
    public ResponseEntity<User> adduser(@RequestBody User user) {
        return new ResponseEntity<User>(service.addUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/orders/{userId}")
    public ResponseEntity<Orders> addOrder(@PathVariable Integer userId, @RequestBody Orders order) {
        return new ResponseEntity<Orders>(service.addOrder(userId, order), HttpStatus.CREATED);
    }

    @PutMapping("/orders/{orderId}/products ")
    public ResponseEntity<Orders> addProductInOrder(@PathVariable Integer orderId, @PathVariable Integer product) {
        return new ResponseEntity<Orders>(service.addProductInOrder(orderId, product), HttpStatus.OK);
    }

    @PutMapping("/orders/{orderId} ")
    public ResponseEntity<Orders> updateOrder(@PathVariable Integer orderId, @RequestBody Orders order) {
        return new ResponseEntity<Orders>(service.updateOrder(order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<List<Orders>> orderHistory(@PathVariable int userId) {
        return new ResponseEntity<List<Orders>>(service.orderHistory(userId), HttpStatus.OK);
    }

    @GetMapping(" /users/{userId}/recommended-products")
    public ResponseEntity<List<Product>> productSuggestion(@PathVariable int userId){
        return new ResponseEntity<List<Product>>(service.productSuggestion(userId),HttpStatus.OK);
    }
}
