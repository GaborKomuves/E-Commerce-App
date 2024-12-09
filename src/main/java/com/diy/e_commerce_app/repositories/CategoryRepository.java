package com.diy.e_commerce_app.repositories;


import com.diy.e_commerce_app.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

