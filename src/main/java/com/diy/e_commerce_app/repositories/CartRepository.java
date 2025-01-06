package com.diy.e_commerce_app.repositories;

import com.diy.e_commerce_app.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for managing cart items.
 */
@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {

    /**
     * Finds a cart item by product ID.
     *
     * @param productId the product ID.
     * @return an optional cart item.
     */
    Optional<CartItem> findByProductId(Long productId);
}
