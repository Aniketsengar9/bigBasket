package com.bigbasket.repository;

import com.bigbasket.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Category findByCategoryName(String categoryName);

}
