package com.bigbasket.service;

import com.bigbasket.entity.Orders;

public interface orderService {

    Orders addOrder(Integer userId,Orders order);
}
