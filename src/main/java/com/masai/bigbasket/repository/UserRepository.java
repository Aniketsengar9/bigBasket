package com.masai.bigbasket.repository;

import com.masai.bigbasket.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
}
