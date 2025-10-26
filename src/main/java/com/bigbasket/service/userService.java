package com.bigbasket.service;

import com.bigbasket.entity.OrderItem;
import com.bigbasket.entity.User;

import java.util.List;


public interface userService {

    User addUser(User user);

    User getUser(Integer id);

    List<User> getAllUsers();

    boolean deleteUserById(Integer userId);

    boolean updateEmailById(Integer userId, String newEmail);

    List<OrderItem> getOrders (Integer userId);

//    Orders  addOrder(int userId,Orders order);
//
//    Orders  addProductInOrder(int orderId,int productid);

//    Orders updateOrder(Orders order);

    // List<Orders> orderHistory(int userId) throws NotFoundException;

    // List<Product> productSuggestion(int userId) throws NotFoundException;
}
