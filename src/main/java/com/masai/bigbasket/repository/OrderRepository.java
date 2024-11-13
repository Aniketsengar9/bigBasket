package com.masai.bigbasket.repository;


import com.masai.bigbasket.entity.Orders;
import com.masai.bigbasket.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface OrderRepository extends JpaRepository<Orders,Integer> {

    public Page<Orders> findByUser(User user, PageRequest pageable);
}
