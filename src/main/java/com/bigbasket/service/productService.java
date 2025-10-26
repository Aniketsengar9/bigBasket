package com.bigbasket.service;

import com.bigbasket.entity.Product;

import java.util.List;
import java.util.Map;

public interface productService {

    Product addProduct(Product product);

    List<Product> getAllProduct();

    List<Product> updateProductQuantities(Map<Integer,Integer> products);
}
