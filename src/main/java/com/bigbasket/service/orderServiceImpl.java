package com.bigbasket.service;

import com.bigbasket.entity.*;
import com.bigbasket.exception.NotFoundException;
import com.bigbasket.repository.OrderRepository;
import com.bigbasket.repository.ProductRepository;
import com.bigbasket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class orderServiceImpl implements orderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Orders addOrder(Integer userId,Orders order) {

        User user = userRepository.findById(userId)
                .orElseThrow(()-> new NotFoundException("No user found with id "+userId));


        Orders ordered = new Orders();
        ordered.setOrderItems(new ArrayList<>());

        double total = 0.0;

        for(OrderItem i : order.getOrderItems()){
            Product product = productRepository.findById(i.getProduct().getProductId())
                    .orElseThrow(()-> new NotFoundException("No Product Found With Id "+i.getProduct().getProductId()));


            double price = product.getPrice() * i.getQuantity();
            int leftQuantity = 0 ;

            if(product.getQuantity() < i.getQuantity()){
                throw new NotFoundException("Only " + product.getQuantity() + " items available for product " + product.getName());
            }

            i.setUser(user);
            i.setPrice(price);
            i.setOrder(ordered);
            i.setProduct(product);
            ordered.getOrderItems().add(i);

            total += price;

            leftQuantity= product.getQuantity() - i.getQuantity();
            if(leftQuantity ==0){
                product.setStatus(Status.OUTOFSTOCK);
            }
            product.setQuantity(leftQuantity);

        }

        ordered.setTotalPrice(total);
        return orderRepository.save(ordered);
    }
}
