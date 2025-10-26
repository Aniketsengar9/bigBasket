package com.bigbasket.service;

import com.bigbasket.entity.Category;
import com.bigbasket.entity.Product;
import com.bigbasket.entity.Status;
import com.bigbasket.exception.NotFoundException;
import com.bigbasket.repository.CategoryRepository;
import com.bigbasket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class productServiceImpl implements productService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product addProduct(Product product) {
        if(product == null) throw new NotFoundException("Please check the input");
        Category category = categoryRepository.findById(product.getCategory().getCategoryId())
                .orElseThrow(
                        () -> new NotFoundException("No category with Id "+product.getCategory().getCategoryId()));
        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAllAvailableProducts();
    }

    @Override
    public List<Product> updateProductQuantities(Map<Integer, Integer> products) {
        List<Product> updatedProduct = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : products.entrySet()){
            int productId = entry.getKey();
            int quantity = entry.getValue();
            Product product = productRepository.findById(productId)
                    .orElseThrow(()-> new NotFoundException("No product with id "+productId +" exists"));
            product.setQuantity(quantity);
            product.setStatus(quantity == 0 ?Status.OUTOFSTOCK : Status.INSTOCK);
            updatedProduct.add(productRepository.save(product));
        }
        return updatedProduct;
    }
}
