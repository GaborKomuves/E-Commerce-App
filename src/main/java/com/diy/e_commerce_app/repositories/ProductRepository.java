package com.diy.e_commerce_app.repositories;

import com.diy.e_commerce_app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
