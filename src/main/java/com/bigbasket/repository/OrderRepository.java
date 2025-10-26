package com.bigbasket.repository;


import com.bigbasket.entity.Orders;
import com.bigbasket.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface OrderRepository extends JpaRepository<Orders,Integer> {

    // public Page<Orders> findByUser(User user, PageRequest pageable);
}
