package com.diy.e_commerce_app.repositories;

import com.diy.e_commerce_app.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Order entities.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom query methods (if needed) can be added here.
}

