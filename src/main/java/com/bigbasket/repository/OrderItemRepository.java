package com.bigbasket.repository;

import com.bigbasket.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {


    @Query("Select oi from OrderItem oi where oi.user.userId = :userId ")
    List<OrderItem> findAllByUserId (@Param("userId") Integer userId);

//    List<OrderItem> findByUserId (@Param("userId") Integer userId);
//    List<OrderItem> findByUser_UserId (@Param("userId") Integer userId);

}
