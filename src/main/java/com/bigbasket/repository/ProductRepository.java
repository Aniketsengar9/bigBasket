package com.bigbasket.repository;

import com.bigbasket.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // public List<Product> findByStatus(Status status);

    // @Query("select p.category.categoryName from Product  p where p.orders.user= user")
    // public List<String> getCategoryName(User user);

    // @Query("Select p from Product  p where p.category.categoryName =?1")
    // public List<Product> getProductByCategoryName();

    @Query("SELECT p FROM Product p WHERE p.status <> OUTOFSTOCK")
    List<Product> getAllAvailableProducts();

}
