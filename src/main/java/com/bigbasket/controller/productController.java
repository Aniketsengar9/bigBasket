package com.bigbasket.controller;

import com.bigbasket.entity.Product;
import com.bigbasket.entity.User;
import com.bigbasket.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class productController {

    @Autowired
    private productService productService;

    @PostMapping("/product/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @PostMapping("/product/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        List<Product> savedProducts = new ArrayList<>();
        for(Product p : products){
            savedProducts.add(productService.addProduct(p));
        }
        return savedProducts;
    }


    @GetMapping("/product/getAll")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PatchMapping("/product/updateQuantity")
    public ResponseEntity<List<Product>> updateQuantity(@RequestBody Map<Integer,Integer> requestBody){
        List<Product> products = productService.updateProductQuantities(requestBody);
        return ResponseEntity.ok(products);
    }


}

