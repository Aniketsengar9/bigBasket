package com.masai.bigbasket.service;

import com.masai.bigbasket.entity.Orders;
import com.masai.bigbasket.entity.Product;
import com.masai.bigbasket.entity.User;
import com.masai.bigbasket.exception.NotFoundException;
import jakarta.persistence.criteria.Order;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface userService {

    User addUser(User user);
    Orders  addOrder(int userId,Orders order);

    Orders  addProductInOrder(int orderId,int productid);

    Orders updateOrder(Orders order);
    List<Orders> orderHistory(int userId) throws NotFoundException;
    List<Product> productSuggestion(int userId) throws NotFoundException;

}
