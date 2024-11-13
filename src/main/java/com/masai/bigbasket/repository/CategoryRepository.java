package com.masai.bigbasket.repository;

import com.masai.bigbasket.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
