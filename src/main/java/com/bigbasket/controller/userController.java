package com.bigbasket.controller;

import com.bigbasket.entity.OrderItem;
import com.bigbasket.entity.Orders;

import com.bigbasket.entity.Product;
import com.bigbasket.entity.User;
import com.bigbasket.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class userController {
    @Autowired
    private userService service;

    @PostMapping("/addUsers")
    public ResponseEntity<User> adduser(@RequestBody User user) {
        return new ResponseEntity<User>(service.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Integer userId){
        User user = service.getUser(userId);
        if(user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUserByID(@PathVariable Integer userId) {
        boolean isDeleted = service.deleteUserById(userId);
        if (isDeleted) {
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @PatchMapping("/updateEmail/{userId}")
    public ResponseEntity<String> updateEmailByID(
            @PathVariable Integer userId,
            @RequestBody Map<String, String> requestBody) {

        String newEmail = requestBody.get("email");
        boolean isUpdated = service.updateEmailById(userId, newEmail);
        if (isUpdated) {
            return ResponseEntity.ok("Email Updated Successfully for User Id: " + userId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<List<OrderItem>> orderHistory(@PathVariable Integer userId){
        return ResponseEntity.ok(service.getOrders(userId));
    }
}
