package com.diy.e_commerce_app.repositories;

import com.diy.e_commerce_app.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing CartItem entities.
 */
@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {
}

