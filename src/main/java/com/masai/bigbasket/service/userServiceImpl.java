package com.masai.bigbasket.service;


import com.masai.bigbasket.entity.Orders;
import com.masai.bigbasket.entity.Product;
import com.masai.bigbasket.entity.Status;
import com.masai.bigbasket.entity.User;
import com.masai.bigbasket.exception.NotFoundException;
import com.masai.bigbasket.repository.OrderRepository;
import com.masai.bigbasket.repository.ProductRepository;
import com.masai.bigbasket.repository.UserRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class userServiceImpl implements userService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public User addUser(User user) {
        if(user == null)throw  new NotFoundException("Please check input");
        return userRepository.save(user) ;
    }

    @Override
    public Orders addOrder(int userId, Orders order) {
        if(order == null)throw  new NotFoundException("Please check input");
        User user = userRepository.findById(userId).orElseThrow(()-> new NotFoundException("User doesnot exists with userId "+userId));
        List<Product> pL = productRepository.findByStatus(Status.INSTOCK);
        if (pL.isEmpty())
            throw new NotFoundException("No product available");
        Product product = pL.get(0);
        order.setUser(user);
        user.getOrdersList().add(order);
        product.setOrders(order);
        return orderRepository.save(order);
    }

    @Override
    public Orders addProductInOrder(int orderId, int productid) {
        Orders orders = orderRepository.findById(orderId).orElseThrow(()->new NotFoundException("No order exists with order id "+orderId));
        Product product = productRepository.findById(productid).orElseThrow(()->new NotFoundException("No product exists with product id "+ productid));
        orders.getProductList().add(product);
        product.setOrders(orders);
        return orderRepository.save(orders);
    }

    @Override
    public Orders updateOrder(Orders order) {
        Orders o1 = orderRepository.findById(order.getOrderId()).orElseThrow(()->new NotFoundException("No order exists with order id "+order.getOrderId()));
        o1.setDeliveryDate(order.getDeliveryDate());
        o1.setNoOfProducts(order.getProductList().size());
        o1.setProductList(order.getProductList());
        return orderRepository.save(o1);
    }

    @Override
    public List<Orders> orderHistory(int userId) throws NotFoundException {
        User user = userRepository.findById(userId).orElseThrow(()->new NotFoundException("No user exists with user id "+userId));
        PageRequest pageable = PageRequest.of(0,5);
        return orderRepository.findByUser(user,pageable).getContent();
    }

    @Override
    public List<Product> productSuggestion(int userId) throws NotFoundException {
        User user = userRepository.findById(userId).orElseThrow(()->new NotFoundException("No user exists with user id "+userId));
        List<String> list = productRepository.getCategoryName(user);
        List<Product> products = new ArrayList<>();
        for(String s : list){
            List<Product> p1 = productRepository.getProductByCategoryName();
            if(!p1.isEmpty()){
                products.addAll(p1);
            }
        }
        return products;
    }
}
