package com.bigbasket.controller;

import com.bigbasket.entity.Orders;
import com.bigbasket.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class orderController {

    @Autowired
    private orderService orderservice;

    @PostMapping("/order/{userId}")
    public ResponseEntity<Orders> order(@PathVariable Integer userId, @RequestBody Orders order){
        return  ResponseEntity.ok(orderservice.addOrder(userId,order));
    }



}
